# WildKingdom

WildKingdom is a command-line ecosystem simulation for CS 3140 Homework 1.
Given a starting number of wolves, rabbits, and months, it predicts the
valley's populations month by month, applying rules for wolf feeding,
starvation, and breeding and for rabbit breeding.

## Quick start

Run directly from source (JDK 22+):

    java src/Main.java 3 10 3

Or compile and run on any JDK 8+:

    javac -d out src/Main.java
    java -cp out Main 3 10 3

Invalid input (wrong argument count, non-integer, or negative value) prints a
usage message; zero is valid. See docs/readme.txt for full instructions.

## Documentation

- docs/readme.txt -- how to run (command line and IntelliJ), input rules, tests
- docs/design.md -- simulation rules, UML, pseudocode, design decisions
- docs/tests.md -- test plan and how to run the tests
- sources.txt -- AI usage disclosure
