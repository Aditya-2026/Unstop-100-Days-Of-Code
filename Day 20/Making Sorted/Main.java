import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; left = null; right = null; }
}

public class Main {
    public static List<Integer> userLogic(List<Integer> bst1Nodes, List<Integer> bst2Nodes) {
        List<Integer> merged = new ArrayList<>();
        merged.addAll(bst1Nodes);
        merged.addAll(bst2Nodes);

        Collections.sort(merged);
        return merged;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> bst1Nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            bst1Nodes.add(sc.nextInt());
        }

        int M = sc.nextInt();
        List<Integer> bst2Nodes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            bst2Nodes.add(sc.nextInt());
        }

        List<Integer> result = userLogic(bst1Nodes, bst2Nodes);

        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
        sc.close();

    }
}