# Design Patterns
<h2>Description</h2>
<b>Practical use of object-oriented techniques to implement typical design patterns (observer, solver) to calculate a nonlinear differential equation describing an inverted pendulum.</b> </br></br>
<p align="center">
<img src="https://i.imgur.com/KaFkrxM.png" width="80%" alt ="waitingForOpp"  width="80%"/>
</p>
<p>
Calculation using one of three numerical methods solving differential equations (solvers):
<ul> 
<li>(1) first order (Euler)</li>
<li>(2) second order (Heun)</li>
<li>(3) fourth order (standard Runge-Kutta method)</li>
</ul>
For simplicity, I assume that the physical parameters and time step will be permanently saved in the application code. The user will be able to select one of the available solvers and provide it
simulation time (Tk), initial tilt angle from the vertical position (Alpha) and initial speed angular (Omega). It can also indicate target places for outputting simulation results (panel with the JList component,
text console window, file).<br><br> Two common design patterns will be used in the application code: the construction pattern production method and functional pattern observer:
<ul>
<li> the manufacturing method will be used to obtain the specific solver object on based on the user's selection before starting the calculations </li>
<li> observer objects will have access to the calculation results during the simulation and will be able to transmit these results to various destinations </li>
</ul> 


 <h2>Languages and Utilities Used</h2>

- <b>Java</b> (SE 21 LTS)
- <b>Java Swing</b> (GUI)

<h2>Environments Used</h2>

- <b>IntelliJ IDEA 2023.3.3</b>

<h2>Libraries Used</h2>

- javax.swing.*
- java.awt.*
- java.io.*
- java.lang.*
- java.util.*

<h2>Program walk-through:</h2>
<p>Solver design pattern - contains elements related to the process of obtaining a solver object and conducting simulations.
</p>
<p align="center">
Class diagram of the solver package <br/>
<img src="https://i.imgur.com/konzIvg.png" width="80%" alt ="SolverDiagram" />
<br />
<br />
<p>
Observer design pattern - track simulation progress and send results to defined recipients.
</p>
<p align="center">
Class diagram of the observer package <br/>
<img src="https://i.imgur.com/h8kRS2e.png" width="70%" alt ="ObserverDiagram"  style="float:left"/>
<img src="https://i.imgur.com/n9BjF3d.png" width="20%" alt="PackageObs" style="float:left"/>
</p>
<p align="center">
Lunching the apllication: <br/>
<img src="https://i.imgur.com/VTYV8Tv.png" width="80%" alt ="Interface" />
</p>
<p align="center">
Saving reults to other places: <br/>
<img src="https://i.imgur.com/G7x02S3.png" width="60%" height="100%" alt ="Adding" style="float:left"/>
<img src="https://i.imgur.com/3ZuIM4k.png" width="25%" height="100%" alt="console" style="float:left"/>
<img src="https://i.imgur.com/sDz7lu0.png" width="80%" alt ="file"/>

 
</p>

