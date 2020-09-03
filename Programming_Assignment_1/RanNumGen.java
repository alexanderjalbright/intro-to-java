class RanNumGen {
    public static void main(String[] args) {
        try {
            // Terminate program if no number is entered,
            // user enters 0 or negative number
            if (args.length == 0 || args[0] == "0" || Integer.parseInt(args[0]) < 0){
                System.out.println("You must enter a number that is greater than 0. Try again.");
                return;
            }
            
            // Get command-line value
            int n = Integer.parseInt(args[0]);
            
            // Create place to hold randomly generated numbers
            int[] numbers = new int[n];

            // Create randomly generated numbers
            for (int i = 0; i < n; i++){
                // Since Math.random outputs a double from 0 - 0.9999~
                // multiply by 100 to get 0 - 99.99~
                // add 1 to get 1 - 100.99
                // cast to int, which rounds down
                // thus result is between 1 - 100 (both inclusive)
                int randomNumber = (int) (Math.random() * 100) + 1;
                numbers[i] = randomNumber;
            };
            
            // Since the first number is guaranteed,
            // save one less iteration through the loop by
            // displaying the first value and initializing min/max with it
            int min = numbers[0];
            int max = numbers[0];
            System.out.print(numbers[0]);
            
            for (int i = 1; i < numbers.length; i++){
                System.out.print(" " + numbers[i]);
                
                // Update the min/max values if next number is higher/lower respectively
                min = Math.min(min,numbers[i]);
                max = Math.max(max,numbers[i]);
            }
            
            System.out.println("\nThe minimum value is " + min + ".");
            System.out.println("The maximum value is " + max + ".");        
        }
        catch (NumberFormatException exception) {
            System.out.println("Try a significantly smaller number.");
            return;
        } catch (OutOfMemoryError error) {
            System.out.println("Try a smaller number.");
            return;
        }
    }
}