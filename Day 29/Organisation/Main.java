import java.util.*;

public class Main {

    static List<List<Integer>> tree;
    static List<Integer> result;

    public static int dfs(int node) {
        int count = 0;
        for (int child : tree.get(node)) {
            count += 1 + dfs(child);
        }
        result.set(node - 1, count);
        return count;
    }

    public static void calculateSubordinates(int V, List<Integer> hierarchy, List<Integer> resultList) {
        tree = new ArrayList<>();
        result = resultList;

        for (int i = 0; i <= V; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < hierarchy.size(); i++) {
            int boss = hierarchy.get(i);
            int emp = i + 2;
            tree.get(boss).add(emp);
        }

        dfs(1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();

        List<Integer> hierarchy = new ArrayList<>();
        for (int i = 0; i < V - 1; i++) {
            hierarchy.add(sc.nextInt());
        }

        List<Integer> result = new ArrayList<>(Collections.nCopies(V, 0));
        calculateSubordinates(V, hierarchy, result);

        for (int x : result) {
            System.out.print(x + " ");
        }
        sc.close();
    }
}
