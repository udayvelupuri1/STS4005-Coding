class bitonicdll
{
   
// structure of node of the doubly linked list
static class Node
{
    int data;
    Node next;
    Node prev;
};


// function to sort a biotonic doubly linked list
static Node sort(Node head)
{
    // If number of elements are less than or
    // equal to 1 then return.
    if (head == null || head.next == null)
    {
        return head;
    }


    // Pointer to first element of doubly
    // linked list.
    Node front = head;


    // Pointer to last element of doubly
    // linked list.
    Node last = head;


    // Dummy node to which resultant
    // sorted list is added.
    Node res = new Node();


    // Node after which next element
    // of sorted list is added.
    Node resEnd = res;


    // Node to store next element to
    // which pointer is moved after
    // element pointed by that pointer
    // is added to result list.
    Node next;


    // Find last element of input list.
    while (last.next != null)
    {
        last = last.next;
    }


    // Compare first and last element
    // until both pointers are not equal.
    while (front != last)
    {

        if (last.data <= front.data)
        {
            resEnd.next = last;
            next = last.prev;
            last.prev.next = null;
            last.prev = resEnd;
            last = next;
            resEnd = resEnd.next;
        }


        // If front element is smaller, then
        // add it to result list and change
        // front pointer to its next element.
        else
        {
            resEnd.next = front;
            next = front.next;
            front.next = null;
            front.prev = resEnd;
            front = next;
            resEnd = resEnd.next;
        }
    }


    // Add the single element left to the
    // result list.
    resEnd.next = front;
    front.prev = resEnd;


    // The head of required sorted list is
    // next to dummy node res.
    return res.next;
}


// Function to insert a node at the beginning
// of the Doubly Linked List
static Node push(Node head_ref, int new_data)
{
    // allocate node
    Node new_node = new Node();


    // put in the data
    new_node.data = new_data;


    // since we are adding at the beginning,
    // prev is always null
    new_node.prev = null;


    // link the old list off the new node
    new_node.next = (head_ref);


    // change prev of head node to new node
    if ((head_ref) != null)
        (head_ref).prev = new_node;


    // move the head to point to the new node
    (head_ref) = new_node;
    return head_ref;
}


// Function to print nodes in a given doubly
// linked list
static void printList(Node head)
{
    // if list is empty
    if (head == null)
        System.out.print( "Doubly Linked list empty");


    while (head != null)
    {
        System.out.print( head.data + " ");
        head = head.next;
    }
}


// Driver code
public static void main(String args[])
{
    Node head = null;


    // Create the doubly linked list:
    // 2<.5<.7<.12<.10<.6<.4<.1
    head = push(head, 1);
    head = push(head, 4);
    head = push(head, 6);
    head = push(head, 10);
    head = push(head, 12);
    head = push(head, 7);
    head = push(head, 5);
    head = push(head, 2);  


    System.out.print("Original Doubly linked list:\n");
    printList(head);


    // sort the biotonic DLL
    head = sort(head);


    System.out.print("\nDoubly linked list after sorting:\n");
    printList(head);
}
}
