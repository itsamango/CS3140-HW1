public class WildKingdom {
    public static void run(String[] args) {
        int wolves = -1, rabbits = -1, months = -1;
        if (args.length == 3) {
            wolves = parse(args[0]);
            rabbits = parse(args[1]);
            months = parse(args[2]);
        }
        if (wolves < 0 || rabbits < 0 || months < 0) {
            System.err.println("Usage: java Main <wolves> <rabbits> <months>");
            return;
        }
        System.out.println("Your program begins with " + wolves + " wolves and "
                + rabbits + " rabbits and runs for " + months + " months.");
        for (int month = 1; month <= months; month++) {
            int fedOnce = Math.min(wolves, rabbits);
            rabbits -= fedOnce;
            int full = Math.min(fedOnce, rabbits);
            rabbits -= full;
            wolves = fedOnce;
            rabbits += (rabbits / 2) * 5;
            wolves += full / 2;
            System.out.println("After month " + month + ": " + wolves
                    + " wolves and " + rabbits + " rabbits");
        }
        System.out.println("At the end of the simulation, there are " + wolves
                + " wolves and " + rabbits + " rabbits.");
    }

    private static int parse(String s) {
        try {
            int v = Integer.parseInt(s);
            return v >= 0 ? v : -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
