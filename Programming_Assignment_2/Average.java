import java.util.*;

public class Average {
    public static void main(String[] args) {
        try {
            // Terminate program if no number is entered,
            // user enters 0 or negative number
            if (args.length == 0 || args[0] == "0" || Integer.parseInt(args[0]) < 0) {
                System.out.println("You must enter a whole number that is greater than 0. Try again.");
                return;
            }

            // Get number of rows to perform average on
            // from command line
            int count = Integer.parseInt(args[0]);

            // Setup place to store names and numbers
            String[] userNames = new String[count];
            int[][] userNumbers = new int[count][3];
            
            // Establish user input from command line
            Scanner sc= new Scanner(System.in);
            // Continue reading until ctrl + z is pressed
            // but track how many
            for (int i = 0; sc.hasNext(); i++) 
            { 
                // Only save data from number of rows specified in args[0]
                if(i < count){
                    // get name
                    userNames[i] = sc.next(); 
                    // get numbers
                    userNumbers[i][0] = sc.nextInt(); 
                    userNumbers[i][1] = sc.nextInt(); 
                    userNumbers[i][2] = sc.nextInt(); 
                }
                else{
                    // ignore remaining lines but allow input
                    sc.nextLine();
                }                 
            }
            
            // Calculate average and print resulting line
            for(int i = 0; i < count; i++){
                double average = (userNumbers[i][0] + userNumbers[i][1] + userNumbers[i][2])/3.00d;
                System.out.printf("%s %d %d %d %.2f%n",userNames[i],userNumbers[i][0],userNumbers[i][1],userNumbers[i][2],average);
            }

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
