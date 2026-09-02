# Homework 1 

The objective of homework 1 is to get set up for class and work with the language and editing tools we will be using: IntelliJ and Java. For this first assignment you will work on your own. You will be graded on completion of tasks listed in the objectives section. Additional detail on how to complete tasks can be found later in this document.

## Narrative

You’ve just started a new job as a software engineer at an intelligence agency. Your direct supervisor, Sam, has given you initial objectives to get you set up to work at the agency. Your mission is to complete them all and then submit the project as an archive on Gradescope.

## Objectives

* Install IntelliJ and Java  
* Install GIT, register a GitHub account if you do not already have one  
* Complete the class form to register your GIT handle and record team preferences   
* Write a program that completes the requirements below for the Java refresher exercise *Prithee*, and submit the Github URL on Gradescope

### Installing IntelliJ

If you don’t have IntelliJ installed from DSA1, you can [download it](https://lp.jetbrains.com/intellij-idea-promo/?source=google&medium=cpc&campaign=AMER_en_US-EST_IDEA_Branded&term=intellij%20idea&content=693444343124&gad_source=1&gad_campaignid=9730672721&gbraid=0AAAAADloJziljqHtp3476WwO5fyxlzI3d&gclid=Cj0KCQiA6sjKBhCSARIsAJvYcpNivoatnoTs1s5h8-Z8fsdNiVbHoYMIwEqm4Kdo0QVmA2elIY12HTYaAq1lEALw_wcB). You should use the free version for students \- a paid license is not required. ([https://www.jetbrains.com/shop/eform/v2/students](https://www.jetbrains.com/shop/eform/v2/students)) For this course, we intend to use Java Version 26\. To run Java programs outside of the editor, you will need a JVM. You can download an [open source JDK](https://bell-sw.com/pages/downloads/#jdk-25-lts). If you encounter errors with your setup of Java or IntelliJ, do your best to resolve the issue on your own, but you can attend TA office hours.

*Can I use an editor other than IntelliJ?*   
You will need IntelliJ when you work with your team, so might as well get it set up now\!

### Installing Git and registering a GitHub account

If you already have a GitHub account, use that. It usually is not worth the additional hassle to have multiple GitHub accounts. If you don’t have an account, you can [sign up](https://github.com/signup). Once registered, [fill out the team sign up form and indicate your GitHub username](https://docs.google.com/forms/d/e/1FAIpQLSfZqN4KuvERf6NgIN95y3HG6j2BsL49BzC3DDi9JbFJ1hYY5g/viewform?usp=publish-editor). We will not use GitHub for homework 1 as the GitHub classroom must first be set up, but we need you to create an account now so we can get it all set up. Expected use of GitHub will be covered in class, and future homework will be submitted using it, starting with either HW2 or 3\. More instructions to follow.

### WildKingdom

WildKingdom is proposed software for modeling the future of an ecosystem. In a valley containing wolves and rabbits, biologists have worked out patterns in the life and deaths of these animals, and they desire a program that will predict the outcome of any scenario they wish to dream up. (You suspect this may be a test designed by Sam to see if you are ready to work on mission critical software\!) 

The program will be run from the command line and will accept three arguments: the number of wolves, the number of rabbits, and the number of months to run the simulation. If the program is run without three valid arguments, the program should display an error message and exit. If the program is run with three valid arguments, the program should output the results after each month, ending with a message formatted as follows:

Your program begins with \_\_\_ wolves and \_\_\_ rabbits and runs for \_\_\_ months.   
…  
At the end of the simulation, there are \_\_\_ wolves and \_\_\_ rabbits.

(Note underscores should be replaced by correct values.)

Rules for calculating the simulation are as follows:

1. A rabbit must live the whole month to produce offspring.  
   2. Each pair of rabbits produce a litter of 5 (at the end of) every month.  
   3. A wolf eats 2 rabbits during each month.  
   4. A wolf who eats no rabbits dies.  
   5. A wolf must live the whole month to produce offspring.  
   6. Each pair of wolves produce 1 new pup (at the end of) every month.

Begin by designing your algorithm on paper, and documenting with pseudocode. (We will do this in class.) Create a new project in IntelliJ. Create a folder, *docs*, to hold documentation. Create a class, *Main*, as the starting point for your program. Create a readme.txt file that includes instructions on how to run the program, in addition to any other documentation you create. If you use AI to generate the solution, create a sources.txt file that indicates the agent, version, and prompt.

Your grade will be a simple checkmark that you turned something in. Don’t get hung up if the program doesn’t work correctly, and avoid the temptation to use the coding assistant to solve the problem. The purpose of the exercise is thinking through the problem, not making the solution. Note this solution may not require a fancy architecture… that’s fine. We will talk more about architecture in the future.

### Submitting your Program on Gradescope

You will submit a GitHub URL to Gradescope for this Assignment.  Graders will download your project and review artifacts and run the program. The program must run; the project must contain all the documentation and tests using the folder structure provided in class. You will be able to update the url until the deadline, but not after the deadline. As a reminder, late work will not be accepted.

### Assessment

The assignment contains documentation on the design of the system.  
The program runs  
Tests are documented and included  
Pseudocode/UML is documented and included  
The program meets the requirements as specified.