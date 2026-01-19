import java.io.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class Main {
    public static TreeNode insertLevelOrder(String[] arr, int i) {
        if (i >= arr.length || arr[i].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[i]));
        root.left = insertLevelOrder(arr, 2 * i + 1);
        root.right = insertLevelOrder(arr, 2 * i + 2);
        return root;
    }

    public static int user_logic(TreeNode root) {
        int[] ways = solve(root);
        return Math.max(ways[0],ways[1]);
    }

    public static int[] solve(TreeNode root){
        if(root == null) return new int[2];

        int[] robLeft = solve(root.left);
        int[] robRight = solve(root.right);

        int[] ways = new int[2];
        ways[0] = root.val + robLeft[1] + robRight[1];
        ways[1] = Math.max(robLeft[0],robLeft[1]) + Math.max(robRight[0],robRight[1]);

        return ways;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().trim().split(" ");
        TreeNode root = insertLevelOrder(data, 0);
        int result = user_logic(root);
        System.out.println(result);
        br.close();
    }
}