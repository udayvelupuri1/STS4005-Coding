class mergesortdll {

    static class Node{  
        int data;  
        Node prev;  
        Node next;  
   
        public Node(int data) {  
            this.data = data;  
        }  
    }  
   
    static Node head,tail = null;  
   
    public static Node addNode(int item) {  
        Node newNode = new Node(item);  
   
        if(head == null) {  
            head = tail = newNode;  
            head.prev = null;  
            tail.next = null;  
        }  
        else {  
            tail.next = newNode;  
            newNode.prev = tail;  
            tail = newNode;  
            tail.next = null;  
        }  

        return head;
    }

    static void print(Node node) {
        Node temp = node;
        System.out.println("Forward Traversal using next pointer");
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println("\nBackward Traversal using prev pointer");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
    }

    // Split a doubly linked list (DLL) into 2 DLLs of
    // half sizes
    static Node split(Node head) {
        Node fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node temp = slow.next;
        slow.next.prev=null;
        slow.next = null;
        return temp;
    }

    static Node mergeSort(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node second = split(node);

        // Recur for left and right halves
        node = mergeSort(node);
        second = mergeSort(second);

        // Merge the two sorted halves
        return merge(node, second);
    }

    // Function to merge two linked lists
    static Node merge(Node first, Node second) {
        // If first linked list is empty
        if (first == null) {
            return second;
        }

        // If second linked list is empty
        if (second == null) {
            return first;
        }

        if (first.data < second.data) {
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

   
    public static void main(String[] args) {
        head=addNode(10);
        head=addNode(30);
        head=addNode(3);
        head=addNode(4);
        head=addNode(20);
       
       
        Node node = null;
        node = mergeSort(head);
        System.out.println("Linked list after sorting :");
        print(node);

    }
}
