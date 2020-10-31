import java.util.regex.Pattern;

public class ISBN {
    public static void main(String[] args) { // start of program
        try {
            // Takes the command-line input provided (args)
            // validates it, and returns it in a useable format
            // which is a string.
            String isbn = GetUserInputs(args);

            // Determine checksum value and print isbn with checksum
            // to command-line
            System.out.println("The ISBN number would be " + getISBNWithChecksum(isbn));

        } catch (IllegalArgumentException ex) {
            // Catches any IllegalArgumentExceptions
            // specifically for ones thrown by the validations
            // for the imputs, and displays them and their reason
            System.out.println(ex.toString());
            return;
        }
    }

    private static String GetUserInputs(String[] commandLineInputs) {
        final int NUMBER_OF_INPUTS = 1;
        // Verifies there are the correct number of command-line arguments
        if (commandLineInputs.length != NUMBER_OF_INPUTS) {
            // If not throw exception to be displayed to user, and terminate program
            throw new IllegalArgumentException("You must enter one 9-digit ISBN number. Try again.");
        }

        ValidateInput(commandLineInputs[0]);

        // Send string back to main to be used in next step
        return commandLineInputs[0];
    }

    private static void ValidateInput(String input) {
        // Create regular expression to check for non-numbers
        Pattern pattern = Pattern.compile("\\D");
        // Search input for non-numbers and return if any found
        boolean nonNumberExists = pattern.matcher(input).find();

        if (nonNumberExists) {
            // If non-numbers found
            // throw exception to be caught in Main
            // to warn user of why input is invalid and
            // terminate program
            throw new IllegalArgumentException("Must enter only numbers.");
        }

        // Verify input provided is exactly 9 digits long
        if (input.length() != 9) {
            throw new IllegalArgumentException("Must enter a 9 digit number.");
        }

        return;
    }

    private static String getISBNWithChecksum(String isbn) {
        // create place to store accumulated sum of each digit multiplied by its
        // respective factor
        int sum = 0;
        // Loop through multiplication factors of 10 to 2
        for (int i = 10; i > 1; i--) {
            // Calculate index of each digit based on current loop index
            int digit = 10 - i;
            // Get numerical value of each digit
            int value = Character.getNumericValue(isbn.charAt(digit));
            // Multiply the factor by the digit and add to sum
            sum += i * value;
        }

        // Calculate number needed to make sum a multiple of 11
        int checksum = 11 - (sum % 11);
        // Convert result of 11 to 0 since checksum is within 0-10
        if (checksum == 11) {
            checksum = 0;
        }

        // Change 10 to X, or get string of any other checksum value
        String checksumStr = checksum == 10 ? "X" : Integer.toString(checksum);
        // Return the isbn with the checksum value back to main
        return isbn + checksumStr;
    }
}