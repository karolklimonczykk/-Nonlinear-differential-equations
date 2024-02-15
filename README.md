# Design Patterns
<h2>Description</h2>
<b>Practical use of object-oriented techniques to implement typical design patterns (observer, solver) to calculate a nonlinear differential equation describing an inverted pendulum.</b> </br></br>
<p align="center">
<img src="https://i.imgur.com/KaFkrxM.png" width="80%" alt ="waitingForOpp"  width="80%"/>
</p>
<p>
Calculation using one of three numerical methods solving differential equations (solvers): (1) first degree (Euler), (2) second degree degree (Heun) and (3) fourth degree (standard Runge-Kutta method).
For simplicity, we assume that the physical parameters and time step will be permanently saved in the application code. The user will be able to select one of the available solvers and provide it
simulation time (Tk), initial tilt angle from the vertical position (Alpha) and initial speed angular (Omega). It can also indicate target places for outputting simulation results (panel with the JList component,
text console window, file). A new GUI element there is a main menu. Two common design patterns will be used in the application code: the construction pattern production method and functional pattern observer:
<ul>
<li> the manufacturing method will be used to obtain the specific solver object on based on the user's selection before starting the calculations </li>
<li> observer objects will have access to the calculation results during the simulation and will be able to transmit these results to various destinations </li>
</ul>
</p>
 
