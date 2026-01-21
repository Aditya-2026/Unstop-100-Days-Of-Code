import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class Main {
    public static void insertNode(ListNode[] head, int val) {
        ListNode newNode = new ListNode(val);
        if (head[0] == null) {
            head[0] = newNode;
            return;
        }
        ListNode temp = head[0];
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public static void printList(ListNode node) {
        if (node == null) {
            System.out.println("null");
            return;
        }
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while(curr != null){
            if(curr.next != null && curr.val == curr.next.val){
                int value = curr.val;

                while(curr.next != null && curr.next.val == value){
                    curr = curr.next;
                }
                prev.next = curr.next;
                curr = curr.next;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode[] head = new ListNode[1];

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            insertNode(head, temp);
        }

        ListNode res = deleteDuplicates(head[0]);
        printList(res);
        sc.close();
    }
}