import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

public class BinarySearch {
    static int _highestIndex;
    static int _lowestIndex;

    public static int search(int key, int[] a) {
        _highestIndex = a.length - 1;
        return search(key, a, 0, a.length);
    }

    public static int search(int key, int[] a, int lo, int hi) {
        // if key doesnt exist in array
        if (hi <= lo) {
            // Grab index before lo if lo is higher than key
            if (a[lo] > key) {
                // Display negative index of lo - 1
                // aka the value before the last lo in the sorted array
                return 0 - lo + 1;
            }
            // if lo is less than key return -index of lo
            return 0 - lo;
        }

        // Calculate middle index between current lo and hi indexes
        int mid = lo + (hi - lo) / 2;

        // Determine if mid is greater than/lower than/equal to key by
        // positive/negative/0 cmp respectively
        int cmp = a[mid] - key;

        // If cmp is greater than 0, guess was too high
        if (cmp > 0) {
            // In order to narrow the window of highest possible index that could match,
            // every time a mid is too high, set the _highestIndex to int before mid
            _highestIndex = mid - 1;
            // rerun search using current lo and mid as the new hi
            return search(key, a, lo, mid);
        } else if (cmp < 0) // If cmp is less than -, guess was too low
            // rerun search using current mid + 1 as low and current hi
            return search(key, a, mid + 1, hi);
        else {
            // if match is found, determine if it is the highest index with a match
            // by looping through the highest index with potential match
            for (int i = _highestIndex; i > mid; i--) {
                // first match is the highest since for loop is going down from highest possible
                // to 1 above mid
                if (a[i] == key) {
                    return i;
                }
            }
            // if no match found in loop, highest match is mid
            return mid;
        }
    }

    public static void main(String[] args) {
        try {
            // Setup place to store numbers
            // Using list initially since array size in file is unknown
            List<Integer> numbers = new ArrayList<Integer>();
            // Establish input from file from command line
            Scanner sc = new Scanner(new FileInputStream(args[0]));
            // loop until no more integers are left in file
            while (sc.hasNextInt()) {
                // Add each number in file to list
                numbers.add(sc.nextInt());
            }

            // Convert list to array since requirements specify array
            int[] userNumbers = ConvertIntListToArray(numbers);

            // Get key from command-line and convert to integer
            int key = Integer.parseInt(args[1]);

            // If all numbers in sorted array are greater than the key display error
            if (userNumbers[0] > key) {
                System.out.println(
                        "Error: All numbers greater than key. Not sure what the result should be from assignment.");
                return;
            }

            // If all numbers in sorted array are less than key, display -i where i is last
            // item in array
            if (userNumbers[userNumbers.length - 1] < key) {
                System.out.println("-" + (userNumbers.length - 1));
                return;
            }

            // Commence binary search
            int result = search(key, userNumbers);

            // Display result to terminal
            System.out.println(result);

        } catch (FileNotFoundException ex) {
            // Catch exception thrown by new FileInputStream() if file does not exist
            System.out.println(ex.toString());
        }
    }

    private static int[] ConvertIntListToArray(List<Integer> list) {
        // Create new array to store list values and be returned by function
        int[] result = new int[list.size()];
        // Since List<Integer>.toArray cannot convert Integer to int
        // manually loop through list and set array to match
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        // return new int array containing input values from file
        return result;
    }
}
