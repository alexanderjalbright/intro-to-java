public class Distribution100 {
    public static void main(String[] args) {
        try {
            // Terminate program if no number is entered,
            // user enters 0 or negative number
            if (args.length == 0 || args[0] == "0" || Integer.parseInt(args[0]) < 0) {
                System.out.println("You must enter a whole number that is greater than 0. Try again.");
                return;
            }

            int count = Integer.parseInt(args[0]);
            
            int countLTEFifty = 0;
            int countGTFifty = 0;

            // Go through each argument after the first
            // and determine if greater than 50
            // or 
            // less than or equal to 50
            for (int i = 1; i <= count; i++){
                if (Integer.parseInt(args[i]) <= 50){
                    countLTEFifty++;
                }
                else{
                    countGTFifty++;
                }
            }
            
            System.out.println(countLTEFifty + " numbers entered are less than or equal to 50.");
            System.out.println(countGTFifty + " numbers entered are greater than 50.");

        } catch (

        NumberFormatException exception) {
            // Intercept any exceptions from incorrect arguments
            // and display helpful message
            System.out.println("You must enter a whole number that is greater than 0. Try again.");
            System.out.println("If you entered a whole number greater than 0, try a significantly smaller number.");
            return;
        } catch (OutOfMemoryError error) {
            System.out.println("Try a smaller number.");
            return;
        }
    }
}
