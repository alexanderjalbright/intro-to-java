public class TriangleTest {
    public static void main(String[] args) { // start of program
        try {
            // Takes the command-line inputs provided (args)
            // validates them, and returns them in a useable format
            // which is an array of integers.
            int[] inputs = GetUserInputs(args);

            // Determines if the inputs are a triangle
            // by checking if any one input is greater than or equal
            // to the sum of the other two.
            Boolean result = IsTriangular(inputs[0], inputs[1], inputs[2]);

            // Print to command-line, based on result
            DisplayResult(result);

        } catch (NumberFormatException exception) {
            // Intercept any NumberFormatException exceptions from arguments
            // that are not numbers, and  display helpful message
            System.out.println("You must enter a natural number that is greater than 0. Try again.");
            System.out.println("If you entered a natural number greater than 0, try a significantly smaller number.");
            return;
        } catch (OutOfMemoryError error) {
            // Intercept any OutOfMemoryError exceptions from arguments
            // that numbers but too large to fit in available memory,
            // and display helpful message
            System.out.println("Try a smaller number.");
            return;
        } catch (IllegalArgumentException ex){
            // Catches any IllegalArgumentExceptions
            // specifically for ones thrown by the validations
            // for the imputs, and displays them and their reason
            System.out.println(ex.toString());
            return;
        }
    }

    private static int[] GetUserInputs(String[] commandLineInputs){
        // Verifies there are the correct number of command-line arguments
        if (commandLineInputs.length != 3 ) {
            // If not throw exception to be displayed to user, and terminate program
            throw new IllegalArgumentException("You must enter three natural numbers. Try again.");
        }

        // Create place to hold 3 numbers provided by user from the command-line
        int[] sides = new int[3];

        // Loop three times to look at each provieded command-line input
        for (int i = 0; i < 3; i++){
            // Parse String input as an integer and save into variable to hold values
            sides[i] = Integer.parseInt(commandLineInputs[i]);
            // Perform validation on inputs
            ValidateInput(sides[i]);            
        }

        // Send array of 3 integers back to main to be used in next step
        return sides;
    }

    private static void ValidateInput(int inputs){
        // Check to make sure inputs are positive
        if (inputs < 1){
            // If found not be positive or zero, 
            // throw exception to be caught in Main
            // to warn user of why input is invalid and 
            // terminate program
            throw new IllegalArgumentException("Must enter positive natural number.");
        }
    }

    private static Boolean IsTriangular(int side1, int side2, int side3){
        // Check to see if any one input is equal to or greater than 
        // the sum of the other two inputs
        if(side1 >= side2 + side3 || side2 >= side1 + side3 || side3 >= side2 + side1){
            // Since not a triangle, send false back to calling method (Main) to be used in next step
            return false;
        }

        // Since it is a triangle, send true back to calling method (Main) to be used in next step
        return true;
    }

    private static void DisplayResult(Boolean result){
        // Prints True if the inputs are a triangle
        // False if they are not
        System.out.println(result ? "True" : "False");
    }
}