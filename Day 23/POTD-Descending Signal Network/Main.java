import java.util.*;

public class Main {

    static class Edge {
        int to;
        int w;
        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static List<List<Edge>> graph;
    static long[] data;
    static boolean[] visited;

    public static long calculateMaxData(int N, int[][] edges, long[] dataValues) {
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(new Edge(e[1], e[2]));
            graph.get(e[1]).add(new Edge(e[0], e[2]));
        }

        data = dataValues;
        long ans = 0;

        for (int hub = 0; hub < N; hub++) {
            visited = new boolean[N];
            ans = Math.max(ans, dfs(hub, -1));
        }

        return ans;
    }

    private static long dfs(int u, int lastWeight) {
        visited[u] = true;
        long sum = data[u];

        for (Edge e : graph.get(u)) {
            if (!visited[e.to] && e.w > lastWeight) {
                sum += dfs(e.to, e.w);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[][] edges = new int[N - 1][3];
        for (int i = 0; i < N - 1; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
            edges[i][2] = scanner.nextInt();
        }

        long[] dataValues = new long[N];
        for (int i = 0; i < N; i++) {
            dataValues[i] = scanner.nextLong();
        }

        System.out.println(calculateMaxData(N, edges, dataValues));
        scanner.close();
    }
}