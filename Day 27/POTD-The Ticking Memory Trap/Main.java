import java.util.*;

public class Main {

    static class Node {
        long sum;
        Node left, right;
        Node(long sum, Node left, Node right) {
            this.sum = sum;
            this.left = left;
            this.right = right;
        }
    }

    static Node build(int l, int r, int[] arr) {
        if (l == r) return new Node(arr[l], null, null);
        int m = (l + r) >> 1;
        Node left = build(l, m, arr);
        Node right = build(m + 1, r, arr);
        return new Node(left.sum + right.sum, left, right);
    }

    static Node update(Node prev, int l, int r, int idx, int val) {
        if (l == r) return new Node(val, null, null);
        int m = (l + r) >> 1;
        if (idx <= m) {
            Node left = update(prev.left, l, m, idx, val);
            return new Node(left.sum + prev.right.sum, left, prev.right);
        } else {
            Node right = update(prev.right, m + 1, r, idx, val);
            return new Node(prev.left.sum + right.sum, prev.left, right);
        }
    }

    static long query(Node node, int l, int r, int ql, int qr) {
        if (node == null || ql > r || qr < l) return 0;
        if (ql <= l && r <= qr) return node.sum;
        int m = (l + r) >> 1;
        return query(node.left, l, m, ql, qr) +
               query(node.right, m + 1, r, ql, qr);
    }

    public static void processQueries(int n, int q, int[] initialArray, int[][] queries, List<Integer> results) {
        Node[] versions = new Node[q + 2];
        versions[1] = build(0, n - 1, initialArray);
        int versionCount = 1;

        for (int i = 0; i < q; i++) {
            int type = queries[i][0];
            if (type == 1) {
                int v = queries[i][1];
                int idx = queries[i][2] - 1;
                int val = queries[i][3];
                versions[++versionCount] = update(versions[v], 0, n - 1, idx, val);
            } else {
                int v = queries[i][1];
                int l = queries[i][2] - 1;
                int r = queries[i][3] - 1;
                results.add((int) query(versions[v], 0, n - 1, l, r));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        int[] initialArray = new int[n];
        for (int i = 0; i < n; i++) initialArray[i] = scanner.nextInt();

        int[][] queries = new int[q][4];
        for (int i = 0; i < q; i++) {
            queries[i][0] = scanner.nextInt();
            queries[i][1] = scanner.nextInt();
            queries[i][2] = scanner.nextInt();
            queries[i][3] = scanner.nextInt();
        }

        List<Integer> results = new ArrayList<>();
        processQueries(n, q, initialArray, queries, results);

        for (int x : results) System.out.println(x);
        scanner.close();
    }
}
