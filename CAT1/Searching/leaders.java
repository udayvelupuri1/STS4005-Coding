package Searching;

//Time Complexity: O(n*n)

import java.util.*;

class leaders {
    static void findLeader(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            int j; //important
            for (j = i + 1; j < n; j++) {
                if (arr[i] <= arr[j]) {
                    break;
                }
            }
            if (j == n) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        findLeader(arr, n);
    }
}
