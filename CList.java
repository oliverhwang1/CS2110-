package linklist;

/*  Name(s):
 * Netid(s):
 * What I thought about this assignment:
 *
 *
 */

/** An instance is a circular doubly linked list. */
public class CList<E> {
    /** Replace "-1" by the time you spent on A3 in hours.<br>
     * Example: for 3 hours 15 minutes, use 3.25<br>
     * Example: for 4 hours 30 minutes, use 4.50<br>
     * Example: for 5 hours, use 5 or 5.0 */
    public static double timeSpent= 5;

    /** Fields head, tail and size implement a circular doubly linked list<br>
     * If the list is empty, head and tail are null.<br>
     *
     * Suppose the list is not empty. <br>
     * Then head points at the first node of the list, field next of each node points<br>
     * at the next node except that field next of the last node points at the first node.<br>
     *
     * Likewise, tail points at the last node of the list, field prev of each node<br>
     * points at the previous node but field prev of the first node points at the last node.<br>
     *
     * Field size contains the number of elements in the list. */
    private Node head, tail;

    /** Length of this circular linked list. */
    private int size;

    /** Constructor: an empty circular doubly linked list.. */
    public CList() {
        // Do not change this method.
    }

    /** = the length of this circular doubly linked list. <br>
     * This function takes constant time. */
    public int size() { // do not change this method
        return size;
    }

    /** = First node of this list (null if the list is empty). */
    public Node head() { // do not change this method
        return head;
    }

    /** = Last node of this list (null if the list is empty). */
    public Node tail() { // do not change this method
        return tail;
    }

    /** Return the data in node n of this list. <br>
     * Precondition: n is a node of this list; it may not be null. */
    public E data(Node n) { // do not change this method
        assert n != null;
        return n.data;
    }

    /** Return a representation of this circular linked list: its data, <br>
     * with adjacent ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     * Takes time proportional to the length of this list.<br>
     * E.g. for the list containing 3 7 8 in that order, the result is "[3, 7, 8]". <br>
     * E.g. for the list containing two empty strings, the result is "[, ]" */
    @Override
    public String toString() {
        if (head == null) return "[]";
        StringBuilder sb= new StringBuilder("[" + head.data);
        Node n= head.next;
        // inv: res contains data in nodes before node n (all of them if n = head),
        // with '[' at the beginning and ", " after each except for the last data item.
        while (n != head) {
            sb.append(", ");
            sb.append(n.data);
            n= n.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /** Return a representation of this circular linked list: its data in reverse order, <br>
     * with adjacent ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     * Takes time proportional to the length of this list. <br>
     * E.g. for the list containing 3 7 8 in that order, the result is "[8, 7, 3]". <br>
     * E.g. for the list containing two empty strings, the result is "[, ]". */
    public String toStringR() { // Note:
        // TODO 1. In writing this, do NOT use fields size and head and the next fields.
        // Use only field tail and the prev and data fields.
        // Use the same scheme as in toString.

        // You can't test this fully until #2, prepend, is written.
        // Extreme case to watch out for: E is String and data items are the empty string.
        if (tail == null) return "[]";
        StringBuilder sb= new StringBuilder("[" + tail.data);

        Node n= tail.prev;

        while (n != tail) {
            sb.append(", ");
            sb.append(n.data);
            n= n.prev;
        }
        sb.append("]");

        return sb.toString();

        // throw new UnsupportedOperationException(); return "[" + new_list + "]"; */
    }

    /** Insert v at the beginning of the list. <br>
     * This operation takes constant time.<br>
     * E.g. if the list is [8, 7, 4], prepend(2) changes this list to [2, 8, 7, 4]. */
    public void prepend(E v) {
        // TODO 2. After writing this method, test this method and method
        // toStringR throughly before starting on the next method.
        // These two must be correct in order to be able to write and test all others.

        if (head == null) {

            head= tail= new Node(null, v, null);
            head.next= tail;
            tail.prev= head;
            tail.next= head;
            size+= 1;

        } else {

            Node temp= head;
            head= new Node(null, v, null);
            head.next= temp;
            temp.prev= head;
            tail.next= head;
            head.prev= tail;
            size+= 1;

        }
        // [8,7,4] [3,8,7,4] tail.next = head
    }       // ^ ^ ^
            // temp v temp

    /** Change the head of this list to head.next and return the new head.<br>
     * Thus, the head becomes the tail.<br>
     * E.g. if the list is [] or [5], the list is unchanged.<br>
     * E.g. With this list is [5, 3, 4, 6], calling the method <br>
     * .... changes the list to [3, 4, 6, 5]. <br>
     * This method takes constant time. */
    public Node changeHeadToNext() {
        // TODO 3.

        if (head == null || head == tail) { return head; }
        Node temp= head;
        head= temp.next;

        tail.next= temp;
        temp.prev= tail;
        tail= temp;
        tail.next= head;
        head.prev= tail;

        return head;
    }

    /** Add v to the end of this list. <br>
     * This operation takes constant time.<br>
     * E.g. if the list is [8, 7, 4], append(2) changes this list to [8, 7, 4, 2]. <br>
     * E.g. if the list is ["AB"], append(null) changes the list to ["AB", null]. */
    public void append(E v) {
        // TODO 4. After writing writing this method, test it thoroughly before
        // moving on to the next one.
        if (head == null) {
            head= tail= new Node(null, v, null);
            head.next= tail;
            tail.prev= head;
            tail.next= head;
            size+= 1;

        } else {

            Node temp= tail;

            tail= new Node(null, v, null);

            temp.next= tail;
            tail.prev= temp;
            tail.next= head;
            head.prev= tail;
            size+= 1;

        }
        // [3,2,4] [3, 2, 4, 8] temp.next = v
        // ^ ^ ^
        // temp temp v

    }

    /** Return node number h. <br>
     * Precondition: 0 <= h < size of the list. <br>
     * Note: If h is 0, return first node; if h = 1, return second node, ... */
    public Node getNode(int h) {

        // TODO 5. This method should take time proportional to min(h, size-h).
        // For example, if h < size/2, search from the beginning of the
        // list, otherwise search from the end of the list.
        // If h = size/2, search from either end; it doesn't matter.
        if (h < size / 2) {
            int i= 0;
            Node temp= head;
            while (i != h) {
                temp= temp.next;
                i+= 1;
            }
            return temp;
        }

        h= size - h;
        int j= 0;
        Node temp= head;
        while (j != h) {
            temp= temp.next;
            j+= 1;
        }

        return temp;
    }

    // [1,2,3,5,7,8] == size=6 h=2 min (2,4) = 2 => return node.data = 3.
    // [5, 10, 15] ==> [5, 10, 18, 15]
    // throw new UnsupportedOperationException();

    // h = 4 size = 5 min(h, size-h) = min(4, 1) = 1; size /2 = 2 -> if h >= size / 2 {
    // [4,5,6,7,8] <- linkedlist; in this case ,return node of 5.

    /** Remove node n from this list. <br>
     * This operation must take constant time. <br>
     * Precondition: n must be a node of this list; it may not be null. */
    public void remove(Node n) {
        // TODO 6. Make sure this method takes constant time.

        Node temp= head;
        while (temp != n) {
            temp= temp.next;
        }
        // temp = tail 7
        Node temp_prev= temp.prev; // 7 tail // 6
        Node temp_next= temp.next; // 4 second //3

        Node temp2= head;
        while (temp2 != temp_prev) {
            temp2= temp2.next;

        }
        // temp2 = 7 tail // 6

        temp2.next= temp_next;
        temp_next.prev= temp2;

        if (head == n) { head= temp_next; }
        if (tail == n) { tail= temp_prev; }

        // [ 3,4,1,6,7] remove node of 3 => [4,1,6,7]
        // [ 3,4,1,6,7] remove node of 7 => [3,4,1,6]
    }

    /** Insert v in a new node before node n. <br>
     * This operation takes constant time. <br>
     * Precondition: n must be a node of this list; it may not be null.<br>
     * E.g. if the list is [3, 8, 2], n points to the node with 8 in it, <br>
     * and v is 1, the list is changed to [3, 1, 8, 2] */
    public void insertBefore(E v, Node n) {
        // TODO 7. Make sure this method takes constant time.
        Node temp= new Node(null, v, null);
        Node temp2= head;
        if (n == head) {
            temp.next= n;
            n.prev= temp;
            tail.next= temp;
            temp.prev= tail;
            head= temp;
        } else {
            while (temp2 != n.prev) {
                temp2= temp2.next;
            }
            temp2.next= temp;
            temp.prev= temp2;
            temp.next= n;
            n.prev= temp;

            // [20, 4, 3, 1, 10] -> [20, 4, 3, 1, 30, 10]
        }
    }

    /*********************/

    /** An instance is a node of this list. */
    public class Node {
        private Node prev; // Previous node on list (tail if this is the first node).
        private E data;    // The data in this node
        private Node next; // Next node on list (head if this is the last node).

        /** Constructor: an instance with previous node p (can be null), data v, and <br>
         * next node s (can be null). */
        Node(Node p, E v, Node s) {
            prev= p;
            data= v;
            next= s;
        }

        /** = the previous node in the list (tail if this is the first node of the list). */
        public Node prev() {
            return prev;
        }

        /** = the data in this node. */
        public E data() {
            return data;
        }

        /** = the next node in this list (head if this is the last node of this list). */
        public Node next() {
            return next;
        }
    }
}
