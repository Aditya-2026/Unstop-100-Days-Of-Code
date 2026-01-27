import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left = null; right = null; }
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

    public static boolean isPseudoPalindrome(int[] freq){
        int count = 0;

        for(int f : freq){
            if((f & 1) == 1){
                if(count == 1) return false;
                else count++;
            }
        }

        return true;
    }

    public static int solve(TreeNode root,int[] freq){
        freq[root.val]++;

        if(root.left == null && root.right == null){
            int res = isPseudoPalindrome(freq) ? 1 : 0;
            freq[root.val]--;
            return res;
        }
        
        int left = 0;
        if(root.left != null) left = solve(root.left,freq);

        int right = 0;
        if(root.right != null) right = solve(root.right,freq);
        
        freq[root.val]--;

        return left + right;
    }

    
    public static int countPalindromicPaths(TreeNode root) {
        int[] freq = new int[10];
        return solve(root,freq);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        TreeNode root = makeTree(0, n, arr);
        int result = countPalindromicPaths(root);
        System.out.println(result);
        scanner.close();
    }
}