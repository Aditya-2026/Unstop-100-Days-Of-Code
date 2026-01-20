import java.util.*;

class Node {
    int val;
    Node next;
    Node(int x) { val = x; next = null; }
}

public class Main {
    public static int check(Node l1, Node l2) {
        int len1 = 0;
        int len2 = 0;

        Node temp1 = l1;
        Node temp2 = l2;

        while(temp1 != null){
            temp1 = temp1.next;
            len1++;
        }
        while(temp2 != null){
            temp2 = temp2.next;
            len2++;
        }

        while(len1 > len2){
            l1 = l1.next;
            len1--;
        }
        
        while(len1 < len2){
            l2 = l2.next;
            len2--;
        }

        while(l1 != null && l2 != null){
            if(l1 == l2){
                return 1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Size of the first linked list
        int m = sc.nextInt();  // Size of the second linked list
        
        Map<Integer, Node> map = new HashMap<>();
        
        // Create first linked list
        Node l1 = new Node(0);
        Node temp = l1;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            if (map.containsKey(t)) {
                temp.next = map.get(t);
            } else {
                temp.next = new Node(t);
                map.put(t, temp.next);
            }
            temp = temp.next;
        }
        l1 = l1.next;
        
        // Create second linked list
        Node l2 = new Node(0);
        temp = l2;
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            if (map.containsKey(t)) {
                temp.next = map.get(t);
            } else {
                temp.next = new Node(t);
                map.put(t, temp.next);
            }
            temp = temp.next;
        }
        l2 = l2.next;
        
        // Call the user logic function
        int result = check(l1, l2);
        System.out.println(result);
        sc.close();
    }
}