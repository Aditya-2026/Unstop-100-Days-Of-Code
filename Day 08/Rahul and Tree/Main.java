import java.util.*;

class Main {
    static class Node {
        int val;
        Node left, right;
        Node(int val) {
            this.val = val;
        }
    }

    public static Node buildBalancedBST(int start ,int end,int[] arr){
        if(start>end){
            return null;
        }
        int mid = start + (end-start+1)/2;
        Node root = new Node(arr[mid]);

        root.left = buildBalancedBST(start,mid-1,arr);
        root.right = buildBalancedBST(mid+1,end,arr);

        return root;
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        
        String left = (root.left == null) ? ".": String.valueOf(root.left.val);
        String right = (root.right == null) ? ".": String.valueOf(root.right.val);

        System.out.println(left +" <- "+root.val+" -> "+ right);

        preOrder(root.left);
        preOrder(root.right);
    }

    public static void userLogic(int N, int[] arr) {
        Arrays.sort(arr);
        Node root = buildBalancedBST(0,N-1,arr);
        preOrder(root);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        userLogic(N, arr);
    }
}