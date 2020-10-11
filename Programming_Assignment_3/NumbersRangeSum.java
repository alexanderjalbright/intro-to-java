public class NumbersRangeSum {
    public static void main(String[] args) { // start of program
        try {
            // Takes the command-line inputs provided (args)
            // validates them, and returns them in a useable format
            // which is an array of integers.
            int[] range = GetUserInputs(args);

            // Determines if the inputs are a triangle
            // by checking if any one input is greater than or equal
            // to the sum of the other two.
            int sum = getSum(range[0], range[1]);

            // Print to command-line, based on result
            DisplayResult(range, sum);

        } catch (NumberFormatException exception) {
            // Intercept any NumberFormatException exceptions from arguments
            // that are not numbers, and display helpful message
            System.out.println("You must enter a natural number that is greater than 0. Try again.");
            System.out.println("If you entered a natural number greater than 0, try a significantly smaller number.");
            return;
        } catch (OutOfMemoryError error) {
            // Intercept any OutOfMemoryError exceptions from arguments
            // that numbers but too large to fit in available memory,
            // and display helpful message
            System.out.println("Try a smaller number.");
            return;
        } catch (IllegalArgumentException ex) {
            // Catches any IllegalArgumentExceptions
            // specifically for ones thrown by the validations
            // for the imputs, and displays them and their reason
            System.out.println(ex.toString());
            return;
        }
    }

    private static int[] GetUserInputs(String[] commandLineInputs) {
        final int NUMBER_OF_INPUTS = 2;
        // Verifies there are the correct number of command-line arguments
        if (commandLineInputs.length != NUMBER_OF_INPUTS) {
            // If not throw exception to be displayed to user, and terminate program
            throw new IllegalArgumentException("You must enter two natural numbers. Try again.");
        }

        // Create place to hold numbers provided by user from the command-line
        int[] inputs = new int[NUMBER_OF_INPUTS];

        // Loop two times to look at each provieded command-line input
        for (int i = 0; i < NUMBER_OF_INPUTS; i++) {
            // Parse String input as an integer and save into variable to hold values
            inputs[i] = Integer.parseInt(commandLineInputs[i]);
            // Perform validation on inputs
            ValidateInput(inputs[i]);
        }

        // Verify first number is less than second number
        if (inputs[0] >= inputs[1]) {
            // If not throw exception to be displayed to user, and terminate program
            throw new IllegalArgumentException("The second number provided must be greater than the first.");
        }

        // Send array of integers back to main to be used in next step
        return inputs;
    }

    private static void ValidateInput(int inputs) {
        // Check to make sure inputs are positive
        if (inputs < 1) {
            // If found not be positive or zero,
            // throw exception to be caught in Main
            // to warn user of why input is invalid and
            // terminate program
            throw new IllegalArgumentException("Must enter positive natural number.");
        }
    }

    private static int getSum(int rangeStart, int rangeEnd) {
        // Create place to store accumulated sum
        int sum = 0;
        // Loop from start of range through each natural number
        // until the end of the range
        for (int i = rangeStart; i <= rangeEnd; i++) {
            // Add each natural number to the accumulated sum
            sum += i;
        }
        // Send value back to Main to be used in next step
        return sum;
    }

    private static void DisplayResult(int[] range, int sum) {
        // Create interpolated string message with range and sum.
        String resultMessage = String.format("The sum of natural numbers in range [%s,%s] is %s.", range[0], range[1],
                sum);
        // Prints the resulting statement showing
        // the range given, and the sum calculated.
        System.out.println(resultMessage);
    }
}
