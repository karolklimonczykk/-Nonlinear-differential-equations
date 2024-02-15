package edu.lab13;

import solver.*;
import observer.*;

import javax.swing.*;
import java.awt.*;

public class CMainForm extends javax.swing.JFrame{
    private JPanel mainPanel;
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuOptions;
    private JMenuItem itemExit;
    private JMenuItem itemSolve;
    private JMenuItem itemAbout;
    private JRadioButton rbFirst;
    private JRadioButton rbSecond;
    private JRadioButton rbFourth;
    private JCheckBox cbPanel;
    private JCheckBox cbConsole;
    private JCheckBox cbFile;
    private JList list1;
    private JTextField tkTextField;
    private JTextField alphaTextField;
    private JTextField omegaTextField;
    private DefaultListModel<Object> model;
    public CMainForm(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        model = new DefaultListModel<>();
        list1.setModel(model);
        itemExit.addActionListener(actionEvent -> CMainForm.this.dispose());
        itemAbout.addActionListener(actionEvent -> JOptionPane.showMessageDialog(CMainForm.this,"" +
                "OOP \nlab 13", "About", JOptionPane.INFORMATION_MESSAGE));
        itemSolve.addActionListener(actionEvent -> solveActionPerformed());

    }
    private void solveActionPerformed(){ 
        CSolverCreator sc = new CSolverCreator();
        try {
            ESolverType st = ESolverType.FIRST_ORDER;
            if(rbSecond.isSelected()) st = ESolverType.SECOND_ORDER;
            else if (rbFourth.isSelected()) st = ESolverType.FOURTH_ORDER;

            CStepData init = new CStepData(
                    Double.parseDouble(tkTextField.getText().trim()),
                    Double.parseDouble(alphaTextField.getText().trim()),
                    Double.parseDouble(omegaTextField.getText().trim())
            );
            if (Double.parseDouble(tkTextField.getText())<0) {
                JOptionPane.showMessageDialog(this, "Simulation time < 0");
                return;
            }
            CSolver solverObj = sc.getSolver(st,init);
            if (cbPanel.isSelected())
                solverObj.addObserver(new CJListObserver(model));
            if (cbConsole.isSelected())
                solverObj.addObserver(new CConsoleObserver());
            if (cbFile.isSelected())
                solverObj.addObserver(new CFileObserver());

            solverObj.solve();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Invalid value. Message: "+e.getMessage());
        }catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Invalid range. Message: " + e.getMessage());
        }

    }

}
