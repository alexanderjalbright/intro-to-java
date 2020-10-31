public class Point {
    // create properties to store point values
    double x;
    double y;
    double z;

    // Constructor: used to assign given values to class properties.
    public Point(double x, double y, double z) {
        // set class properties to provided values
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void main(String[] args) {
        try {
            // Get 6 double values from command-line inputs
            // and store in double array
            double[] inputs = GetUserInputs(args);

            // Create two Point class instances with user provided values
            Point point1 = new Point(inputs[0], inputs[1], inputs[2]);
            Point point2 = new Point(inputs[3], inputs[4], inputs[5]);

            // Print to command line each point,
            System.out.println("The first point is " + point1.toString());
            System.out.println("The second point is " + point2.toString());
            // and the distance between them.
            System.out.format("Their Euclidean distance is %.2f\n", point1.distanceto(point2));

        } catch (NumberFormatException exception) {
            // Intercept any NumberFormatException exceptions from arguments
            // that are not numbers, and display helpful message
            System.out.println("You must enter numbers. Try again.");
            return;
        } catch (OutOfMemoryError error) {
            // Intercept any OutOfMemoryError exceptions from arguments
            // that numbers but too large to fit in available memory,
            // and display helpful message
            System.out.println("Try smaller numbers.");
            return;
        } catch (IllegalArgumentException ex) {
            // Catches any IllegalArgumentExceptions
            // specifically for ones thrown by the validations
            // for the imputs, and displays them and their reason
            System.out.println(ex.toString());
            return;
        }
    }

    private static double[] GetUserInputs(String[] commandLineInputs) {
        final int NUMBER_OF_INPUTS = 6;
        // Verifies there are the correct number of command-line arguments
        if (commandLineInputs.length != NUMBER_OF_INPUTS) {
            // If not throw exception to be displayed to user, and terminate program
            throw new IllegalArgumentException("You must enter one 9-digit ISBN number. Try again.");
        }

        // Create place to hold numbers provided by user from the command-line
        double[] inputs = new double[NUMBER_OF_INPUTS];

        // Loop six times to look at each provieded command-line input
        for (int i = 0; i < NUMBER_OF_INPUTS; i++) {
            // Parse String input as a double and save into array to hold values
            inputs[i] = Double.parseDouble(commandLineInputs[i]);
        }

        // Send array of doubles back to main to be used in next step
        return inputs;
    }

    public double distanceto(Point q) {
        // Calculate Euclidean distance by
        // taking the square root of the sum of the squares of
        // the difference of each Points' x, y, and z value.

        // Calculate difference of each value
        double xDiff = x - q.x;
        double yDiff = y - q.y;
        double zDiff = z - q.z;

        // Calculate square of each difference
        double xSquare = Math.pow(xDiff, 2);
        double ySquare = Math.pow(yDiff, 2);
        double zSquare = Math.pow(zDiff, 2);

        // Calculate sum of all squares
        double sum = xSquare + ySquare + zSquare;

        // Calculate Euclidean distance by square root of sum
        double distance = Math.sqrt(sum);

        // Remove decimals past hundreths place to match example in assigment
        // description
        return Math.floor(distance * 100) / 100;
    }

    public String toString() {
        // create string of point
        // like (x,y,z)
        return String.format("(%.1f,%.1f,%.1f)", x, y, z);
    }
}
