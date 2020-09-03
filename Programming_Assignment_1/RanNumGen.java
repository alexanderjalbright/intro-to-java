import java.util.Arrays;

class RanNumGen {
    public static void main(String[] args) {
        try {
            // Terminate program if no number is entered,
            // user enters 0 or negative number
            if (args.length == 0 || args[0] == "0" || Integer.parseInt(args[0]) < 0){
                System.out.println("You must enter a whole number that is greater than 0. Try again.");
                return;
            }
            
            // Get command-line value
            int n = Integer.parseInt(args[0]);
            
            // Create place to hold randomly generated numbers
            int[] numbers = new int[n];
            
            // Create randomly generated numbers
            int min = 0;
            int max = 0;
            for (int i = 0; i < n; i++){
                // Since Math.random outputs a double from 0 - 0.9999~
                // multiply by 100 to get 0 - 99.99~
                // add 1 to get 1 - 100.99
                // cast to int, which rounds down
                // thus result is between 1 - 100 (both inclusive)
                int randomNumber = (int) (Math.random() * 100) + 1;
                // Display each number and update the min/max values if next number is higher/lower respectively
                if(i == 0){
                    System.out.print(randomNumber);
                    min = randomNumber;
                    max = randomNumber;
                }
                else{
                    System.out.print(" " + randomNumber);
                    min = Math.min(min,randomNumber);
                    max = Math.max(max,randomNumber);
                }                
            };
            
            System.out.println("\nThe minimum value is " + min + ".");
            System.out.println("The maximum value is " + max + ".");        
        }
        catch (NumberFormatException exception) {
            System.out.println("You must enter a whole number that is greater than 0. Try again.");
            System.out.println("If you entered a whole number greater than 0, try a significantly smaller number.");
            return;
        } catch (OutOfMemoryError error) {
            System.out.println("Try a smaller number.");
            return;
        }
    }
}