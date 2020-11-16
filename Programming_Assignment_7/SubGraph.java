import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SubGraph {
    // Changed to utilize HashMap, since I dont have whatever library
    // provides the ST from the book
    private HashMap<String, HashSet<String>> st;

    public SubGraph() {
        st = new HashMap<String, HashSet<String>>();
    }

    public void addEdge(String v, String w) {
        if (!st.containsKey(v))
            st.put(v, new HashSet<String>());
        if (!st.containsKey(w))
            st.put(w, new HashSet<String>());
        st.get(v).add(w);
        st.get(w).add(v);
    }

    public HashSet<String> adjacentTo(String v) {
        return st.get(v);
    }

    public Iterable<String> vertices() {
        return st.keySet();
    }

    public static void main(String[] args) {
        try {
            // Create instance of the SubGraph to be used in Main
            SubGraph G = new SubGraph();
            // Create scanner to read file given as first command line argument
            Scanner fileScanner = new Scanner(new FileInputStream(args[0]));
            // Loop through lines in file
            // Setting each pair of values as a key and value for eachother
            while (fileScanner.hasNext()) {
                G.addEdge(fileScanner.next(), fileScanner.next());
            }

            // print out the graph
            System.out.println("The graph is");
            // by looping through each key (vertice)
            for (String vertice : G.vertices()) {
                // printing that vertice
                System.out.print(vertice + ": ");
                // and looping through the values for that vertice
                for (String value : G.adjacentTo(vertice)) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }

            // print out subgraph based on other command line arguments
            System.out.println("The subgraph is");
            // Loop through each key (vertice)
            for (String vertice : G.vertices()) {
                // Create bool used to determine if the current vertice is one of the ones
                // listed by the user
                Boolean isInUserVertices = false;
                for (int i = 1; i < args.length; i++) {
                    // Check if any of the command line arguments matches the current vertice in the
                    // loop
                    if (args[i].equals(vertice)) {
                        // when a match is found, print that vertice
                        System.out.print(vertice + ": ");
                        // and loop through the values for that vertice
                        for (String value : G.adjacentTo(vertice)) {
                            // loop through command line arguments again to check for matches
                            for (int j = 1; j < args.length; j++) {
                                if (args[j].equals(value)) {
                                    // if match is found, print value
                                    System.out.print(value + " ");
                                }
                            }
                        }
                        System.out.println();
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            // Catch exception thrown by new FileInputStream() if file does not exist
            System.out.println(ex.toString());
        }
    }
}
