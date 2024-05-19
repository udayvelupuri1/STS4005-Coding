import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

class StackPerm {
    static boolean checkStackPermutation(int ip[], int op[], int n) {
        Queue<Integer> input = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            input.add(ip[i]);
        }

        Queue<Integer> output = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            output.add(op[i]);
        }

        Stack<Integer> st = new Stack<>();
        while (!input.isEmpty()) {
            st.push(input.poll());
            while (!st.isEmpty() && st.peek().equals(output.peek())) {
                st.pop();
                output.poll();
            }
        }
        return (input.isEmpty() && st.isEmpty());
    }

    public static void main(String[] args) {
        int input[] = { 1, 2, 3 };

        int output[] = { 2, 1, 3 };
        int n = 3;
        if (checkStackPermutation(input, output, n))
            System.out.println("Yes");
        else
            System.out.println("Not Possible");
    }
}
