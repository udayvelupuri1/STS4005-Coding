class PqUsingDLL {

    static Node front, rear;

    static class Node {
        char info;
        int priority;  
        Node prev, next;
    }

    static void display() {  
        Node current = front;  
        if(isEmpty()) {  
            System.out.println("List is empty");  
            return;  
        }  
        System.out.println("Nodes of doubly linked list: ");  
        while(current != null) {  
 
            System.out.print("In " + current.info + " pr " + current.priority+" \n");  
            current = current.next;  
        }  
    }  

    static void push(char n, int p)
    {
        Node news = new Node();
        news.info = n;
        news.priority = p;

        if (isEmpty()) {
            front = news;
            rear = news;
            news.next = null;
        }
        else {
            if (p <= (front).priority) {
                news.next = front;
                front.prev = news;
                front = news;
            }

            else if (p > (rear).priority) {
                news.next = null;
                (rear).next = news;
                news.prev = rear;
                rear = news;
            }

            else {

                Node start = (front).next;
                while (start.priority < p)
                    start = start.next;
                (start.prev).next = news;
                news.prev = start.prev;
                news.next = start;
                start.prev = news;
            }
        }
       
    }

    static char peek() {
        return front.info;
    }

    static boolean isEmpty() {
        return (front == null);
    }

    static char pop()
    {
        Node temp = front;
        char res = temp.info;
        (front) = (front).next;

        if (isEmpty())
            rear = null;

        return res;
    }

    public static void main(String args[])
    {

        push('b', 3);
        push( 'c', 4);
        push( 'e', 6);
        push( 'f', 7);
        push( 'a', 2);
        push( 'd', 5);

        display();

        System.out.println("peek1 "+peek());
        System.out.println("poped elt "+pop());
        System.out.println("peek2 "+peek());
    }
}
