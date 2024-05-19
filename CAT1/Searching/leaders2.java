package Searching;

//Time Complexity: O(n)

public class leaders2 {

    void findleaders2(int arr[], int n) {

        int max_from_right = arr[n - 1];

        System.out.print(max_from_right + " ");

        for (int i = n - 2; i >= 0; i--) {
            if (max_from_right < arr[i]) {
                max_from_right = arr[i];
                System.out.print(max_from_right + " ");
            }
        }

    }

    public static void main(String[] args) {
        int arr[] = new int[] { 16, 17, 4, 3, 5, 2 };
        int n = arr.length;
        leaders2 lead = new leaders2();
        lead.findleaders2(arr, n);
    }

}
