package Searching;

//Time Complexity O(n^2)

import java.util.*;

class equilibriumsum {
    static int findEquilibriumSum(int arr[], int n) {
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            int preSum = arr[i];

            for (int j = 0; j < i; j++) {
                preSum += arr[j];
            }

            int suffSum = arr[i];

            for (int j = n - 1; j > i; j--) {
                suffSum += arr[j];
            }

            if (preSum == suffSum) {
                res = Math.max(res, preSum);
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findEquilibriumSum(arr, n));

    }
}
