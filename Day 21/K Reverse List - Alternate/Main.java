import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}

public class Main {
    public static ListNode swapPairs(ListNode head) {
        if(head==null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while(prev.next != null && prev.next.next != null){
            ListNode first = prev.next;
            ListNode second = first.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first; 
        }

        return dummy.next;
    }

    public static ListNode stringToListNode(String input) {
        input = input.substring(1, input.length() - 1).trim();
        if (input.isEmpty()) return null;
        String[] parts = input.split("[, ]+");
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (String part : parts) {
            ptr.next = new ListNode(Integer.parseInt(part));
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) return "[]";

        StringBuilder result = new StringBuilder();
        result.append("[");

        while (node != null) {
            result.append(node.val);
            if (node.next != null) {
                result.append(", ");
            }
            node = node.next;
        }

        result.append("]");
        return result.toString();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ListNode head = stringToListNode(input);
        ListNode swappedHead = swapPairs(head);
        System.out.println(listNodeToString(swappedHead));
    }
}