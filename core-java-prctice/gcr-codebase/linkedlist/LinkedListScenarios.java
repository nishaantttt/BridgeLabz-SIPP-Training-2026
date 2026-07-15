public class LinkedListScenarios {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Insert After
    static void insertAfter(Node current, int value) {
        if (current == null) return;

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete Node
    static Node removeTask(Node head, int value) {
        if (head == null)
            return null;

        if (head.val == value)
            return head.next;

        Node prev = head;
        Node curr = head.next;

        while (curr != null && curr.val != value) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null)
            prev.next = curr.next;

        return head;
    }

    // Reverse Linked List
    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Find Middle
    static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Detect Cycle
    static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    // Merge Two Sorted Lists
    static Node merge(Node a, Node b) {
        Node dummy = new Node(-1);
        Node tail = dummy;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        if (a != null)
            tail.next = a;
        else
            tail.next = b;

        return dummy.next;
    }

    // Print List
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // Create List: 10 -> 20 -> 30 -> 40
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println("Original List:");
        printList(head);

        // Scenario 1 : Insert After
        insertAfter(head.next, 25);
        System.out.println("\nAfter Insert 25 after 20:");
        printList(head);

        // Scenario 2 : Delete Node
        head = removeTask(head, 30);
        System.out.println("\nAfter Removing 30:");
        printList(head);

        // Scenario 3 : Reverse
        head = reverse(head);
        System.out.println("\nAfter Reversing:");
        printList(head);

        // Scenario 4 : Middle
        Node middle = findMiddle(head);
        System.out.println("\nMiddle Node: " + middle.val);

        // Scenario 5 : Cycle Detection
        System.out.println("\nCycle Present? " + hasCycle(head));

        // Create Cycle
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = head.next;

        System.out.println("Cycle Present After Creating Cycle? " + hasCycle(head));

        // Break Cycle for further use
        temp.next = null;

        // Scenario 6 : Merge Sorted Lists

        Node a = new Node(1);
        a.next = new Node(3);
        a.next.next = new Node(5);

        Node b = new Node(2);
        b.next = new Node(4);
        b.next.next = new Node(6);

        Node merged = merge(a, b);

        System.out.println("\nMerged Sorted List:");
        printList(merged);
    }
}