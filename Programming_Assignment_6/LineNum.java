import java.util.Scanner;

public class LineNum {
    public static void main(String[] args) {
        // Initialize instance of the Queue class created below
        // in order to store user input strings
        Queue<String> queue = new Queue<String>();

        // Establish user input from command line
        Scanner sc = new Scanner(System.in);

        // Continue reading until ctrl + z(ctrl + d) is pressed
        while (sc.hasNext()) {
            // Add each line (word) entered by the user to the queue
            queue.enqueue(sc.nextLine());
        }

        // Get number of word to be returned by getting the command-line argument and
        // converting it to a number
        int number = Integer.parseInt(args[0]);

        // Create place outside of loop to store the word being obtained
        String result = "";
        // Loop only the number of times the number user inputed in the command line
        for (int i = 0; i < number; i++) {
            // Each loop, remove the oldest entry from the queue
            result = queue.dequeue();
        }
        // Loop will stop when result is equal to the desired word

        // Print result as shown in assignment
        System.out.println(number + " from the first is " + result);
    }
}

// Program 4.3.6 (Introduction to Programming and Java)
// Added since java.utils.Queue is abstract so an instance cannot be created of
// it directly.
// Also, I was unsure if LinkedList and its methods add/remove were permitted.
public class Queue<String> {
    private Node first;
    private Node last;

    private class Node {
        private String item;
        private Node next;
    }

    public Boolean isEmpty() {
        return (first == null);
    }

    public void enqueue(String item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
    }

    public String dequeue() {
        String item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        return item;
    }
}
