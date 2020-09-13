public class LC {
    public static void main(String args[]) {
        // To get the numbers 1 - 100
        // the for loop starts at 1,
        // and stops when it reaches 101
        for (int i = 1; i <= 100; i++) {
            // Modulus operator checks that there is no remainder
            // when divided by 10, therefore this is the last
            // number for the current line
            if (i % 10 == 0) {
                // Terminate the current line by using println
                // "\n" could be used alternatively
                System.out.println(i);
            } else {
                // Display first 9 numbers per line separated by a space
                // for readability
                System.out.print(i + " ");
            }
        }
    }
}
