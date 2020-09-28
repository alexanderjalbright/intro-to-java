public class RelativelyPrimeArray {
    public static void main(String[] args) {
        try {
            // Terminate program if no number is entered,
            // user enters 0 or negative number
            if (args.length == 0 || args[0] == "0" || Integer.parseInt(args[0]) < 0) {
                System.out.println("You must enter a whole number that is greater than 0. Try again.");
                return;
            }

            int n = Integer.parseInt(args[0]);

            Boolean[][] rpa = new Boolean[n][n];

            // loop through rows
            for (int i = 0; i < n; i++) {
                // loop through columns
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0){
                        rpa[i][j] = true;
                        continue;
                    }

                    // Determine if each point in the grid is Relateively Prime
                    int nextDividend ;
                    // convert index to "user numbers" by adding 1 
                    int gcd = i+1;
                    int remainder = j+1;

                    // Determine the greatest common divisor 
                    // between current row and column
                    while(remainder != 0){  
                        nextDividend = gcd;      
                        gcd = remainder;      
                        remainder = nextDividend%remainder;    
                    }                    
                    // if the greatest common divisor is 1,
                    // then then i+1 and j+1 are relatively prime
                    rpa[i][j] = gcd == 1;
                }
            }

            // Print Headers
            System.out.print("  ");
            for (int i = 1; i <= n; i++) {
                if (i == n) {
                    System.out.println(i + " ");
                } else {
                    System.out.print(i + " ");
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.print(i + 1 + " ");

                if (n >= 10 && i < 10) {
                    System.out.print(" ");
                }

                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        System.out.print("  ");
                    } else if (rpa[i][j]) {
                        System.out.print("T ");
                    } else {
                        System.out.print("F ");
                    }

                    if (j > 10) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
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
