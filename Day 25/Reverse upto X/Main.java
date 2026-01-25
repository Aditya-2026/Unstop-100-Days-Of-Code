import java.util.*;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    Node tail;
    LinkedList() {
        this.head = null;
        this.tail = null;
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    void push(int data) {
        if (head == null) {
            Node temp = new Node(data);
            head = temp;
            tail = temp;
        } else {
            Node temp = new Node(data);
            tail.next = temp;
            tail = temp;
        }
    }
}

public class Main {
    public static void reverseLinkedListUpToX(LinkedList ll, int x) {
        if (ll.head == null) return;

        Node curr = ll.head;
        Node prev = null;
        Node next;

        Node start = ll.head;
        Node afterX = null;
        boolean found = false;

        while (curr != null) {
            next = curr.next;

            curr.next = prev;

            if (curr.data == x) {
                afterX = next;
                prev = curr;
                found = true;
                break;
            }

            prev = curr;
            curr = next;
        }

        if (found) {
            ll.head = prev;
            start.next = afterX;
        } else {
            ll.head = prev;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            ll.push(t);
        }
        int x = sc.nextInt();
        reverseLinkedListUpToX(ll, x);
        ll.print();
        sc.close();
    }
}