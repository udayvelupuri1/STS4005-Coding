import java.util.*;
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class cycleDetectLL {

    public static Node insert(Node head, int n) {
        Node new_node = new Node(n);

        if (head == null) {
            return new_node;
        }
        Node curr = head;

        while (curr.next != null) {
            curr = curr.next;

        }
        curr.next = new_node;
        return head;
    }

    public static boolean detectLoop(Node head) {

        if (head == null || head.next == null) {
            return false;
        }

        Node tortoise = head;
        Node hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            if (hare == tortoise) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = null;

        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            for(int i=0;i<n;i++){
                head = insert(head, sc.nextInt());
            }
        }
        

        // cycle

        //head.next.next.next.next = head.next;

        System.out.println("is Loop present? " + detectLoop(head));

    }

}
