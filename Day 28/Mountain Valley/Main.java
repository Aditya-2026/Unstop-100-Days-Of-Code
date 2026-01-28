import java.util.*;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    public static int countNodes(Node head) {
        if (head == null || head.next == null) return 0;

        int count = 0;
        Node prev = head;
        Node curr = head.next;

        while (curr.next != null) {
            Node next = curr.next;
            if (curr.data > prev.data && curr.data > next.data) {
                count++;
            }
            prev = curr;
            curr = next;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node head = null, tail = null;
        for (int i = 0; i < n; i++) {
            Node node = new Node(sc.nextInt());
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        System.out.println(countNodes(head));
        sc.close();
    }
}
