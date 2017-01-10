# Measuring-Stability-Using-the-Reflection-API
A Java application that uses reflection to analyse an arbitrary Java Application Archive (JAR) and calculates the positional stability of each of the component classes in its object graph.

# Table of Contents
* [Introduction](#introduction)
* [Installation](#installation)
* [Project Details](#details)

#<a name="introduction"></a>Introduction
The Positional Stability (I) of a type can be measured bycounting the number of dependencies that enter and leave that type: <br/><b>I = Ce / (Ca + Ce)</b><br/>
<b>Afferent Couplings (Ca)</b>: the number of edges incident on a type, i.e. the number of
types with a dependency on another type.<br/>
<b>Efferent Couplings (Ce)</b>: the number of edges emanating from a type, i.e. the number
of types that a given type is dependent upon
<br/>


#<a name="installation"></a>Installation
1. Open source files in an IDE.
2. Run the Runner class.
3. Browse for a JAR file you want to analyze
4. Click Analyze JAR when you've chosen a file.
5. Click Show Results to see the results of the tool.

#<a name="details"></a>Project Details

The Project uses the Model View Controller(MVC) pattern to split up the code into components.

The View Classes are: <br/>
1. AppWindow.java  - This class is the frame that holds the views of the program. <br/>
2. AppSummary.java - This class shows the results of the positional stability analysis. <br/>
 <br/>
Next are the Controller Classes <br/>
1.  PSCalculator.java   - this has all the functionality for making the calculation <br/>
2. AnalyzerCtrl  - handles the running of the PSCalculator <br/>
3. JarCtrl - handles the importing of a java jar file for analysis <br/>
4. ResultsCtrl - handles the passsing of results data into the swing table <br/>
 
Last are the Model Classes <br/>
1. Metric - this classes holds the variables for keeping track of the classes and affrent and effernt coupling stats as well as the final stability figure <br/>
2. TypeSummaryTableModel - this class filles the java swing table to show the results of the analysis



