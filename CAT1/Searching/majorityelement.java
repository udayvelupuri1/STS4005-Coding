package Searching;

/*majority element o(n^2)*/

import java.util.*;

class majorityelement {
    static void majority(int arr[], int n) {
        int max = 0, index = 0, count;
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j])
                    count++;
            }
            if (count > max) {
                max = count;
                index = i;
            }
        }

        if (max > n / 2) {
            System.out.println("Majority element : " + arr[index]);
        } else {
            System.out.println("No");
        }

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        majority(arr, n);
    }
}