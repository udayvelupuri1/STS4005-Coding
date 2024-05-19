package Searching;

//Time Complexity O(n)

class equilibriumSum2 {

    static int findMaxSum(int arr[], int n) {

        int presum[] = new int[n];
        int suffsum[] = new int[n];

        int res = Integer.MIN_VALUE;

        presum[0] = arr[0];

        for (int i = 1; i < n; i++)
            presum[i] = presum[i - 1] + arr[i];

        suffsum[n - 1] = arr[n - 1];

        if (presum[n - 1] == suffsum[n - 1])
            res = Math.max(res, presum[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            suffsum[i] = suffsum[i + 1] + arr[i];

            if (suffsum[i] == presum[i]) {
                res = Math.max(res, presum[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int arr[] = {-1, 2, 3, 0, 3, 2, -1};
        int n = arr.length;
        System.out.println(findMaxSum(arr, n));
    }
}