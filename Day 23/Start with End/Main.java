import java.util.*;

class Node {
    int val;
    Node next;
    Node(int x) { val = x; next = null; }
}

public class Main {
    public static Node buildLinkedList(int size, int[] elements) {
        if (size == 0) return null;
        Node head = new Node(elements[0]);
        Node tail = head;
        for (int i = 1; i < size; i++) {
            tail.next = new Node(elements[i]);
            tail = tail.next;
        }
        return head;
    }

    public static int pairSum(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        while(slow != null){
            Node next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        int maxPairSum = Integer.MIN_VALUE;
        Node first = head;
        Node second = prev;

        while(second != null){
            int pair = first.val + second.val;
            if(pair > maxPairSum){
                maxPairSum = pair;
            }
            first = first.next;
            second = second.next;
        }

        return maxPairSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] elements = new int[n];
        for (int i = 0; i < n; i++) {
            elements[i] = scanner.nextInt();
        }
        Node head = buildLinkedList(n, elements);
        int result = pairSum(head);
        System.out.println(result);
    }
}
