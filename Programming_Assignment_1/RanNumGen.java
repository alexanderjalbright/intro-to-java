class RanNumGen {
    public static void main(String[] args) {
        if (args.length == 0 || args[0] == "0"){
            System.out.println("You must enter a number greater than 0. Try again.");
            return;
        }

        int n = Integer.parseInt(args[0]);

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++){
            int randomNumber = (int) (Math.random() * 100) + 1;
            numbers[i] = randomNumber;
        };

        int min = numbers[0];
        int max = numbers[0];
        System.out.print(numbers[0]);
        
        for (int i = 1; i < numbers.length; i++){
            System.out.print(" " + numbers[i]);

            min = Math.min(min,numbers[i]);
            max = Math.max(max,numbers[i]);
        }
        
        System.out.println("\nThe minimum value is " + min + ".");
        System.out.println("The maximum value is " + max + ".");        
    }
}