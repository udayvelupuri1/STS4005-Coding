package Recursion;

public class manuevering {

    static int findpaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        return findpaths(m - 1, n) + findpaths(m, n - 1);
    }

    public static void main(String args[]) {
        System.out.println(findpaths(3, 3));
    }

}
