import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class Main {
    public static ListNode removeLastOccurrences(ListNode head) {
        Map<Integer,Integer> map = new HashMap<>();
        ListNode curr = head;

        while(curr != null){
            map.put(curr.val,map.getOrDefault(curr.val,0) + 1);
            curr = curr.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        curr = head;

        while(curr != null){
            map.put(curr.val,map.get(curr.val) - 1);

            if(map.get(curr.val) > 0){
                tail.next = curr;
                tail = curr;
            }

            curr = curr.next;
        }
        tail.next = null;
        return dummy.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        if (n == 0) {
            System.out.println();
            return;
        }

        String[] values = scanner.nextLine().trim().split(" ");
        ListNode head = new ListNode(Integer.parseInt(values[0]));
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(Integer.parseInt(values[i]));
            current = current.next;
        }

        ListNode modified_head = removeLastOccurrences(head);

        printLinkedList(modified_head);
        scanner.close();
    }
}