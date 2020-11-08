import java.util.Scanner;

public class LinkedStackOfStrings {
    private Node first;

    private class Node {
        private String item;
        private Node next;
    }

    public Boolean isEmpty() {
        return (first == null);
    }

    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    // used to find string within the stack
    public Boolean find(String searchWord) {
        // Create place to store currently inspected node in the stack
        Node current = first;
        // Loop until the stack runs out, if no matches found
        while (current != null) {
            // Check if the item in the current node contains the search word
            if (current.item.matches("(.*)" + searchWord + "(.*)")) {
                // if so, a match has been found, so return true
                return true;
            } else {
                // Otherwise, check the next node
                current = current.next;
            }
        }
        // If the loop exits from current being null, then no match was found
        return false;
    }

    public static void main(String[] args) {
        // Establish user input from command line
        Scanner sc = new Scanner(System.in);

        // Continue reading until ctrl + z(ctrl + d) is pressed
        while (sc.hasNext()) {
            // Add each line (word) entered by the user to the queue
            push(sc.nextLine());
        }

        // Grab search word from command-line inputs
        // save in variable "word" so the remaining code is more readable
        String word = args[0];

        // Search stack for the user command-line input word
        Boolean result = find(word);

        // Print results based on if the word is found or not
        if (result) {
            System.out.println(word + " exists in the linked stack");
        } else {
            System.out.println(word + " does not exist in the linked stack");
        }
    }
}
