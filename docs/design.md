# WildKingdom Design

## Overview

WildKingdom models a valley ecosystem of wolves and rabbits. The program is run
from the command line with three arguments -- the starting number of wolves,
the starting number of rabbits, and the number of months to simulate. For each
month it applies rules for eating, starvation, and breeding, prints the
resulting populations, and ends with a summary of the final counts. The
simulation is deterministic: the same arguments always produce the same output.

The program consists of two source files. `Main.java` is the entry point
required by the assignment; it does nothing but call `WildKingdom.run`.
`WildKingdom.java` holds all of the logic: argument validation, the monthly
simulation loop, and output.

## Simulation rules

The six rules from the assignment:

1. A rabbit must live the whole month to produce offspring.
2. Each pair of rabbits produces a litter of 5 at the end of every month.
3. A wolf eats 2 rabbits during each month.
4. A wolf who eats no rabbits dies.
5. A wolf must live the whole month to produce offspring.
6. Each pair of wolves produces 1 new pup at the end of every month.

Interpretation notes -- how the rules are applied in the code:

- Wolves eat round-robin in two passes: first every wolf eats one rabbit if it
  can; then the wolves that were fed eat a second rabbit until the rabbits run
  out.
- A wolf that eats 0 rabbits dies.
- A wolf that eats exactly 1 rabbit survives but does not breed. Only
  fully-fed wolves (2 rabbits) breed.
- Pairs are formed with integer division, so an unpaired odd animal breeds
  nothing.
- Offspring are born at the end of the month; they do not eat or breed until
  the following month.
- The simulation runs all requested months; there is no early exit when a
  population reaches zero.

## UML

```
+----------------------------+             +----------------------------------------+
|            Main            |             |               WildKingdom              |
+----------------------------+  run(args)  +----------------------------------------+
| + main(String[] args)      |----------->| + run(String[] args) : void            |
|     : void (static)        |             | - parse(String s) : int                |
+----------------------------+             +----------------------------------------+
```

`Main` is a conventional public class whose static `main` method delegates to
`WildKingdom.run`. `+` marks public members and `-` private members. `main`
calls `WildKingdom.run`, and `run` calls the private helper `parse` to convert
each argument to an integer.

## Pseudocode

The pseudocode below matches the implementation in `WildKingdom.java` exactly.
In the printed lines, W, R, and M abbreviate the current values of wolves,
rabbits, and months, and `month` is the loop counter.

```
RUN(args):
    wolves, rabbits, months = -1
    if args has exactly 3 entries:
        wolves = parse(args[0]); rabbits = parse(args[1]); months = parse(args[2])
    if wolves < 0 or rabbits < 0 or months < 0:
        print "Usage: java Main <wolves> <rabbits> <months>" to stderr
        return
    print "Your program begins with W wolves and R rabbits and runs for M months."
    for month = 1 to M:
        fedOnce = min(W, R)          // pass 1: every wolf eats one rabbit if it can
        R = R - fedOnce
        full = min(fedOnce, R)       // pass 2: fed wolves eat a second until rabbits run out
        R = R - full
        W = fedOnce                  // wolves that ate nothing die
        R = R + (R / 2) * 5          // each surviving rabbit pair has 5 kits
        W = W + (full / 2)           // each pair of fully-fed wolves has 1 pup
        print "After month month: W wolves and R rabbits"
    print "At the end of the simulation, there are W wolves and R rabbits."

PARSE(s):
    try to read s as an integer; return it if >= 0, otherwise -1
```

## Design decisions

- `Main` is the entry point, as the assignment requires. It contains only the
  `main` method and delegates all logic to `WildKingdom.run`, keeping the entry
  point trivial and letting tests call the simulation directly.
- `Main` is a conventional class with a static `main` method, and the program
  uses no language features newer than Java 8, so graders can compile and run
  it on any JDK from 8 upward.
- Populations and counters are `int`s. Integer division by 2 implements the
  pair-based breeding rules directly, so there are no fractional animals.
- No external libraries are used; the program needs only `System.out`,
  `System.err`, and `Math.min`.
- Output wording follows the templates in the assignment exactly.
