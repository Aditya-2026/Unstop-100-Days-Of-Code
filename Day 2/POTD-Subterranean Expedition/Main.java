import java.util.*;

public class Main {
    public static int maxArtifactValue(int N, int M, int K, int[] caveValues, List<int[]> tunnels) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++)
            graph.add(new ArrayList<>());

        for (int[] e : tunnels) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int x = Integer.MIN_VALUE / 2;
        int[][] dp = new int[K + 1][N];

        for (int i = 0; i <= K; i++) {
            Arrays.fill(dp[i], x);
        }

        dp[0][0] = caveValues[0];

        for (int step = 1; step <= K; step++) {
            for (int u = 0; u < N; u++) {
                if (dp[step - 1][u] == x)
                    continue;
                for (int v : graph.get(u)) {
                    dp[step][v] = Math.max(dp[step][v], dp[step - 1][u] + caveValues[v]);
                }
            }
        }

        int ans = x;
        for (int step = 0; step <= K; step++) {
            ans = Math.max(ans, dp[step][N - 1]);
        }

        return ans == x ? -1 : ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();

        int[] caveValues = new int[N];
        for (int i = 0; i < N; i++) {
            caveValues[i] = scanner.nextInt();
        }

        List<int[]> tunnels = new ArrayList<int[]>();
        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            tunnels.add(new int[] { u, v });
        }

        int result = maxArtifactValue(N, M, K, caveValues, tunnels);
        System.out.println(result);
    }
}