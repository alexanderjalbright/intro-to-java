import java.util.Arrays;

public class MergeSort {
    // Changed Comparable[] to String[] to avoid:
    // Note: MergeSort.java uses unchecked or unsafe operations.
    // Note: Recompile with -Xlint:unchecked for details.
    public static void sort(String[] a) {
        String[] aux = new String[a.length];
        sort(a, aux, 0, a.length);
    }

    // Changed to String[] from Comparable[] to avoid the following warnings:
    // Note: MergeSort.java uses unchecked or unsafe operations.
    // Note: Recompile with -Xlint:unchecked for details.
    private static void sort(String[] a, String[] aux, int lo, int hi) {
        if (hi - lo <= 1)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid, hi);
        int i = lo, j = mid;
        for (int k = lo; k < hi; k++)
            if (i == mid)
                aux[k] = a[j++];
            else if (j == hi)
                aux[k] = a[i++];
            else if (a[j].compareTo(a[i]) < 0)
                aux[k] = a[j++];
            else
                aux[k] = a[i++];
        for (int k = lo; k < hi; k++)
            a[k] = aux[k];

    }

    public static void main(String[] args) {
        // Get index of first word of sorted portion of the given words
        int sortStartIndex = Integer.parseInt(args[0]);
        // Get index of last word of sorted portion of the given words
        int sortEndIndex = Integer.parseInt(args[1]);

        // Grab words from command-line input and put in own array for
        // easily determining the indexes.
        String[] words = Arrays.copyOfRange(args, 2, args.length);

        // If there are words before the sorted section
        if (sortStartIndex != 0) {
            // Create new array of them and print them separated by a space.
            printArray(Arrays.copyOfRange(words, 0, sortStartIndex));
        }

        // Create new array of just the section chosen to be sorted
        String[] sortable = Arrays.copyOfRange(words, sortStartIndex, sortEndIndex + 1);
        // Sort section chosen to be sorted
        sort(sortable);
        // Print sorted section
        printArray(sortable);

        // If there are words after the sorted section
        if (sortEndIndex != words.length - 1) {
            // Create new array of them, and print them
            printArray(Arrays.copyOfRange(words, sortEndIndex + 1, words.length));
        }

        // Terminate printed line
        System.out.println();
    }

    // Prints given array to console, with strings separated by a space
    private static void printArray(String[] arr) {
        // Loop throught each index within the given array
        for (int i = 0; i < arr.length; i++)
            // Print each string to the console followed by a space
            System.out.print(arr[i] + " ");
    }
}
