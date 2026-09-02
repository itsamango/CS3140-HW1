import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MainTest {
    static final String USAGE = "Usage: java Main <wolves> <rabbits> <months>";
    static int passed = 0;
    static int failed = 0;

    public static void main(String[] args) {
        simulation("3 10 3 full simulation", new String[]{"3", "10", "3"}, """
                Your program begins with 3 wolves and 10 rabbits and runs for 3 months.
                After month 1: 4 wolves and 14 rabbits
                After month 2: 6 wolves and 21 rabbits
                After month 3: 9 wolves and 29 rabbits
                At the end of the simulation, there are 9 wolves and 29 rabbits.""");
        simulation("3 4 1 no pair no pup", new String[]{"3", "4", "1"}, """
                Your program begins with 3 wolves and 4 rabbits and runs for 1 months.
                After month 1: 3 wolves and 0 rabbits
                At the end of the simulation, there are 3 wolves and 0 rabbits.""");
        simulation("5 3 2 starvation collapse", new String[]{"5", "3", "2"}, """
                Your program begins with 5 wolves and 3 rabbits and runs for 2 months.
                After month 1: 3 wolves and 0 rabbits
                After month 2: 0 wolves and 0 rabbits
                At the end of the simulation, there are 0 wolves and 0 rabbits.""");
        simulation("3 0 1 no rabbits", new String[]{"3", "0", "1"}, """
                Your program begins with 3 wolves and 0 rabbits and runs for 1 months.
                After month 1: 0 wolves and 0 rabbits
                At the end of the simulation, there are 0 wolves and 0 rabbits.""");
        simulation("0 2 2 rabbits breed unchecked", new String[]{"0", "2", "2"}, """
                Your program begins with 0 wolves and 2 rabbits and runs for 2 months.
                After month 1: 0 wolves and 7 rabbits
                After month 2: 0 wolves and 22 rabbits
                At the end of the simulation, there are 0 wolves and 22 rabbits.""");
        simulation("2 2 0 zero months", new String[]{"2", "2", "0"}, """
                Your program begins with 2 wolves and 2 rabbits and runs for 0 months.
                At the end of the simulation, there are 2 wolves and 2 rabbits.""");
        usage("no args", new String[]{});
        usage("3 10 x non-integer months", new String[]{"3", "10", "x"});
        usage("-1 5 2 negative wolves", new String[]{"-1", "5", "2"});
        usage("3 10 two args", new String[]{"3", "10"});
        usage("1 2 3 4 four args", new String[]{"1", "2", "3", "4"});
        System.out.println(passed + " passed, " + failed + " failed");
    }

    static void simulation(String name, String[] args, String expected) {
        List<String> expectedLines = normalize(expected);
        List<String> actualLines = normalize(out(args));
        if (expectedLines.equals(actualLines)) {
            pass(name);
        } else {
            fail(name, reason(expectedLines, actualLines));
        }
    }

    static void usage(String name, String[] args) {
        String stdout = out(args).trim();
        String stderr = err(args).trim();
        if (!stdout.isEmpty()) {
            fail(name, "stdout not empty: \"" + stdout + "\"");
        } else if (!stderr.equals(USAGE)) {
            fail(name, "expected usage line on stderr but got \"" + stderr + "\"");
        } else {
            pass(name);
        }
    }

    static String out(String[] args) {
        return capture(args)[0];
    }

    static String err(String[] args) {
        return capture(args)[1];
    }

    static String[] capture(String[] args) {
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;
        ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();
        ByteArrayOutputStream errBuffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuffer));
        System.setErr(new PrintStream(errBuffer));
        try {
            Main.main(args);
        } finally {
            System.setOut(originalOut);
            System.setErr(originalErr);
        }
        return new String[]{outBuffer.toString(), errBuffer.toString()};
    }

    static List<String> normalize(String text) {
        List<String> lines = new ArrayList<>();
        for (String line : text.split("\\R")) {
            lines.add(line.trim());
        }
        while (!lines.isEmpty() && lines.get(lines.size() - 1).isEmpty()) {
            lines.remove(lines.size() - 1);
        }
        return lines;
    }

    static String reason(List<String> expected, List<String> actual) {
        int shared = Math.min(expected.size(), actual.size());
        for (int i = 0; i < shared; i++) {
            if (!expected.get(i).equals(actual.get(i))) {
                return "line " + (i + 1) + " expected \"" + expected.get(i)
                        + "\" but got \"" + actual.get(i) + "\"";
            }
        }
        return "expected " + expected.size() + " lines but got " + actual.size();
    }

    static void pass(String name) {
        passed++;
        System.out.println("PASS: " + name);
    }

    static void fail(String name, String reason) {
        failed++;
        System.out.println("FAIL: " + name + " — " + reason);
    }
}
