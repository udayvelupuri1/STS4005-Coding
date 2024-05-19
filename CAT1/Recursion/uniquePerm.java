package Recursion;

import java.util.Arrays;

//O(N*N!)

public class uniquePerm {

    // Count of total permutations
    static int total = 0;

    static void permute(int i, String s) {
        // Base case
        if (i == (s.length() - 1)) {
            System.out.print(s + "\n");
            total++;
            return;
        }

        char prev = '*';

        // Loop from j = i to length of String
        for (int j = i; j < s.length(); j++) {
            char[] temp = s.toCharArray();

            // Skip duplicate characters
            if (j > i && temp[i] == temp[j]) {
                continue;
            }

            // Skip if the previous character is the same as the current
            if (prev != '*' && prev == s.charAt(j)) {
                continue;
            }

            // Swap the elements
            temp = swap(temp, i, j);
            prev = s.charAt(j);

            // Recursion call
            permute(i + 1, String.valueOf(temp));
        }
    }

    static char[] swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    static String sortString(String inputString) {
        // Convert input string to char array
        char[] tempArray = inputString.toCharArray();

        // Sort tempArray
        Arrays.sort(tempArray);

        // Return new sorted string
        return new String(tempArray);
    }

    // Driver code
    public static void main(String[] args) {
        String s = "abca";

        // Sort the string to handle duplicates
        s = sortString(s);

        // Function call to generate permutations
        permute(0, s);
        System.out.print("Total distinct permutations = " + total + "\n");
    }
}
