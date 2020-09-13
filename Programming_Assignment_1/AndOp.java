public class AndOp {
    public static void main(String[] args) {
        try {
            // Terminate program if user does not provide 2 arguments
            if (args.length != 2) {
                System.out.println("You must enter two decimal numbers. Try again.");
                return;
            }

            // Get command-line values
            double firstDouble = Double.parseDouble(args[0]);
            double secondDouble = Double.parseDouble(args[1]);

            // Default result to false
            String result = "false";

            // Determine if both numbers meet the requirements of being between 0 and 1
            if (firstDouble < 1 && firstDouble > 0 && secondDouble < 1 && secondDouble > 0) {
                result = "true";
            }

            System.out.println(result);
        } catch (NumberFormatException exception) {
            System.out.println("You must enter two decimal numbers. Try again.");
            return;
        }
    }
}
