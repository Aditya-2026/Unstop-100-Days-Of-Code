import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class Main {
    public static TreeNode makeTree(int idx, int n, int[] arr) {
        if (idx >= n || arr[idx] == -1) {
            return null;
        }
        TreeNode root = new TreeNode(arr[idx]);
        root.left = makeTree(2 * idx + 1, n, arr);
        root.right = makeTree(2 * idx + 2, n, arr);
        return root;
    }

    public static int solve(TreeNode root,int curr){
        if(root == null){
            return 0;
        }

        curr = (curr << 1) | root.val;

        if(root.left == null && root.right == null){
            return curr;
        }

        int left = solve(root.left,curr);
        int right = solve(root.right,curr);

        return left + right;
    }

    public static int userLogic(TreeNode root) {
        return solve(root,0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        TreeNode root = makeTree(0, n, arr);
        int result = userLogic(root);
        System.out.println(result);
        scanner.close();
    }
}