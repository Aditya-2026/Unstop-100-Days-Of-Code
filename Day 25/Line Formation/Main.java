import java.util.*;

class Node {
    int val;
    Node next;
    Node(int x) { val = x; next = null; }
}

public class Main {
    public static int minChanges(Node head, int n) {
        int arr[] = new int[n];
        Node curr = head;
        int i = 0;
        while(curr != null){
            arr[i++] = curr.val;
            curr = curr.next;
        }

        Arrays.sort(arr);

        curr = head;
        int count = 0;
        for(int j=0;j<n;j++){
            if(arr[j] != curr.val) count++;
            curr = curr.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }
        
        Node head = new Node(values[0]);
        Node temp = head;
        for (int i = 1; i < values.length; i++) {
            temp.next = new Node(values[i]);
            temp = temp.next;
        }
        
        int result = minChanges(head, n);
        System.out.println(result);
        sc.close();
    }
}