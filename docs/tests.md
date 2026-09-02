# WildKingdom Tests

## How to run

From the project root:

    java src/MainTest.java

The test driver requires no JUnit and no build tools; like the program itself,
it runs directly from source. It prints PASS or FAIL for each case followed by
a summary line of the form `11 passed, 0 failed`.

## How the tests work

`MainTest.java` is a plain Java program. For each case it:

1. Captures standard output and standard error by redirecting `System.out`
   and `System.err` into in-memory buffers.
2. Calls `Main.main` with the case's arguments.
3. Restores the original streams.
4. Compares the captured output against the expected output for the case.
   For simulation cases, stdout is compared line by line (the first differing
   line is reported on failure). For usage-error cases, stdout must be empty
   and stderr must equal the usage message.

Because the tests call `Main.main` directly, they exercise the exact program
entry point and check the exact text the program produces, including the begin
line, every monthly line, and the final line.

## Test cases

| #  | Arguments   | Behavior exercised                                                                 | Expected result                                                                                          |
|----|-------------|------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| 1  | `3 10 3`    | Full simulation; every wolf fully fed every month; wolf and rabbit breeding        | Begins 3/10 for 3 months; month 1: 4 wolves, 14 rabbits; month 2: 6, 21; month 3: 9, 29; ends 9, 29     |
| 2  | `3 4 1`     | Rabbits run out in pass 2; only one wolf fully fed; no wolf pair forms, no pup     | Month 1: 3 wolves, 0 rabbits; ends 3, 0                                                                  |
| 3  | `5 3 2`     | Rabbits run out in pass 1; two wolves starve immediately, the rest the next month  | Month 1: 3, 0; month 2: 0, 0; ends 0, 0                                                                  |
| 4  | `3 0 1`     | No rabbits at all; every wolf dies in month 1                                      | Month 1: 0 wolves, 0 rabbits; ends 0, 0                                                                  |
| 5  | `0 2 2`     | No wolves; rabbits breed unchecked                                                 | Month 1: 0 wolves, 7 rabbits; month 2: 0, 22; ends 0, 22                                                 |
| 6  | `2 2 0`     | Zero months (a valid value); no monthly lines printed                              | Only the begin line and the end line; populations unchanged (2, 2)                                       |
| 7  | (none)      | Usage error: no arguments                                                          | stdout empty; stderr is the usage message                                                                |
| 8  | `3 10 x`    | Usage error: non-integer argument                                                  | stdout empty; stderr is the usage message                                                                |
| 9  | `-1 5 2`    | Usage error: negative value                                                        | stdout empty; stderr is the usage message                                                                |
| 10 | `3 10`      | Usage error: two arguments (wrong count)                                           | stdout empty; stderr is the usage message                                                                |
| 11 | `1 2 3 4`   | Usage error: four arguments (wrong count)                                          | stdout empty; stderr is the usage message                                                                |

The exact expected stdout for case 1:

    Your program begins with 3 wolves and 10 rabbits and runs for 3 months.
    After month 1: 4 wolves and 14 rabbits
    After month 2: 6 wolves and 21 rabbits
    After month 3: 9 wolves and 29 rabbits
    At the end of the simulation, there are 9 wolves and 29 rabbits.

For the usage-error cases (7-11) the exact expected stderr is:

    Usage: java Main <wolves> <rabbits> <months>

For the valid-input cases (1-6), stdout is the complete program output for
that scenario -- the begin line, the monthly lines, and the end line -- and
stderr is empty.
