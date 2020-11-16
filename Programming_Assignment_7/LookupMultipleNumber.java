import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class LookupMultipleNumber {
    public static void main(String[] args) {
        try {
            // Create scanner to gather inputs from text file
            Scanner fileScanner = new Scanner(new FileInputStream(args[0]));
            // Store 2nd command line argument as the max number of matches to display
            int maxNumOfValues = Integer.parseInt(args[1]);
            // Store the 3rd command line argument as the csv field used for the key
            int keyField = Integer.parseInt(args[2]);
            // Store the 4th command line argument as the csv field used for the value
            int valField = Integer.parseInt(args[3]);

            // Create place to store incoming from file
            List<String> database = new ArrayList<String>();
            // loop through each line in file
            while (fileScanner.hasNextLine()) {
                // Add each line from the file to the list
                database.add(fileScanner.nextLine());
            }

            // Create hashmap to store the values that match the keys
            HashMap<String, Queue<String>> st = new HashMap<String, Queue<String>>();
            // Loop through each line in the list
            for (int i = 0; i < database.size(); i++) {
                // Separate comma delimited values
                String[] tokens = database.get(i).split(",");
                // save the current key
                String key = tokens[keyField];
                // save the current value
                String val = tokens[valField];
                // If the key already exists in the values and
                // the max value has not been reached
                // store value in queue for that key
                if (st.containsKey(key)) {
                    Queue<String> existingQueue = st.get(key);
                    if (existingQueue.size() < maxNumOfValues) {
                        existingQueue.enqueue(val);
                    }
                } else {
                    // Otherwise start a new queue for that new key
                    Queue<String> queue = new Queue<String>();
                    queue.enqueue(val);
                    st.put(key, queue);
                }
            }

            // Establish user input from command line
            Scanner inputScanner = new Scanner(System.in);

            // Continue reading until ctrl + z(ctrl + d) is pressed
            while (inputScanner.hasNext()) {
                // store line entered by user
                String s = inputScanner.nextLine();
                // get the queue of values for the key given by user
                Queue<String> queue = st.get(s);
                // print each value from the queue
                while (!queue.isEmpty()) {
                    System.out.print(queue.dequeue() + " ");
                }
                System.out.println();
            }
        } catch (FileNotFoundException ex) {
            // Catch exception thrown by new FileInputStream() if file does not exist
            System.out.println(ex.toString());
        }
    }
}

// Program 4.3.6 (Introduction to Programming and Java)
// Added since java.utils.Queue is abstract so an instance cannot be created of
// it directly.
// Also, I was unsure if LinkedList and its methods add/remove were permitted.
public class Queue<String> {
    private Node first;
    private Node last;
    // Added lengh to track size of Queue
    private int length = 0;

    private class Node {
        private String item;
        private Node next;
    }

    public Boolean isEmpty() {
        return (first == null);
    }

    // Added size() to get current size of queue externally
    public int size() {
        return length;
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
        length += 1;
    }

    public String dequeue() {
        String item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        length -= 1;
        return item;
    }
}