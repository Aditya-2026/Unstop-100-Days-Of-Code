import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left = null; right = null; }
}

public class Main {
    public static TreeNode createTree(String[] data) {
        if (data.length == 0 || data[0].equals("N")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(data[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < data.length) {
            TreeNode current = queue.poll();

            if (i < data.length && !data[i].equals("N")) {
                current.left = new TreeNode(Integer.parseInt(data[i]));
                queue.add(current.left);
            }
            i++;

            if (i < data.length && !data[i].equals("N")) {
                current.right = new TreeNode(Integer.parseInt(data[i]));
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static List<Integer> leftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();

                if(i==0) result.add(curr.val);

                if(curr.left != null) q.add(curr.left);

                if(curr.right != null) q.add(curr.right);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] treeNodes = new String[n];
        for (int i = 0; i < n; i++) {
            treeNodes[i] = sc.next();
        }

        TreeNode root = createTree(treeNodes);

        List<Integer> result = leftView(root);

        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
        sc.close();
    }
}
