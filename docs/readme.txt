9/3/2026
Luke Benfer

WildKingdom
===========

WildKingdom is a command-line ecosystem simulation. The program accepts three
arguments -- the starting number of wolves, the starting number of rabbits, and
the number of months to simulate -- and predicts how the valley's populations
change, applying rules for wolf feeding, starvation, and breeding and for
rabbit breeding. It prints the populations after each month and ends with a
summary of the final counts. The program is a single class: src/Main.java
contains the entry point and all simulation logic.

Requirements
------------
The program uses no language features newer than Java 8, so it compiles and
runs on any JDK from 8 upward. Running directly from source without compiling
requires JDK 22 or later (verified on JDK 26). The tests use text blocks, so
they need JDK 15 or later when compiled, or JDK 22+ to run from source. There
is no external library either way.

Running from the command line
-----------------------------
From the project root:

    java src/Main.java <wolves> <rabbits> <months>

Example:

    java src/Main.java 3 10 3

Exact output of the example:

    Your program begins with 3 wolves and 10 rabbits and runs for 3 months.
    After month 1: 4 wolves and 14 rabbits
    After month 2: 6 wolves and 21 rabbits
    After month 3: 9 wolves and 29 rabbits
    At the end of the simulation, there are 9 wolves and 29 rabbits.

Compiling and running on any JDK
--------------------------------
From the project root:

    javac -d out src/Main.java
    java -cp out Main 3 10 3

The out/ directory is already listed in .gitignore.

Running in IntelliJ
-------------------
Open the project in IntelliJ IDEA and open src/Main.java. Run Main once to
create its run configuration, then open Run > Edit Configurations..., select
the Main configuration, enter the program arguments in the Program arguments
field (for example: 3 10 3), and run it.

Invalid input
-------------
Input is invalid when the argument count is not exactly three, when any
argument is not an integer, or when any argument is negative; zero is a valid
value. On invalid input the program prints

    Usage: java Main <wolves> <rabbits> <months>

to standard error and exits.

Running the tests
-----------------
From the project root:

    java src/MainTest.java

The test driver prints PASS or FAIL for each case and a summary at the end.
It requires no JUnit and no build tools. On JDK 15 through 21 (before direct
source launch was available), compile first with the same pattern:

    javac -d out src/MainTest.java src/Main.java
    java -cp out MainTest

Further documentation
---------------------
docs/design.md   Design documentation: simulation rules and interpretation
                 notes, UML diagram, pseudocode, and design decisions.
docs/tests.md    Test documentation: how the tests work and the full list of
                 cases with expected results.
docs/sources.txt AI usage disclosure.
