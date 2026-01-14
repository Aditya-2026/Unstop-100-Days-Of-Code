import java.util.*;

public class Main {
    public static void solveTimeRiftQueries(int N, int M, int[] A, int[][] updates, int Q, int[][] queries) {
        int[][] versions = new int[M + 1][N];
        System.arraycopy(A, 0, versions[0], 0, N);

        for (int i = 1; i <= M; i++) {
            int pos = updates[i - 1][0] - 1;
            int val = updates[i - 1][1];
            int base = updates[i - 1][2];
            System.arraycopy(versions[base], 0, versions[i], 0, N);
            versions[i][pos] = val;
        }

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            int V = queries[i][0];
            int L = queries[i][1] - 1;
            int R = queries[i][2] - 1;
            int K = queries[i][3];

            int len = R - L + 1;
            int[] temp = new int[len];
            for (int j = 0; j < len; j++) {
                temp[j] = versions[V][L + j];
            }

            Arrays.sort(temp);
            out.append(temp[K - 1]).append('\n');
        }

        System.out.print(out.toString());
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        int[][] updates = new int[M][3];
        for (int i = 0; i < M; i++) {
            updates[i][0] = scanner.nextInt();
            updates[i][1] = scanner.nextInt();
            updates[i][2] = scanner.nextInt();
        }

        int Q = scanner.nextInt();
        int[][] queries = new int[Q][4];
        for (int i = 0; i < Q; i++) {
            queries[i][0] = scanner.nextInt();
            queries[i][1] = scanner.nextInt();
            queries[i][2] = scanner.nextInt();
            queries[i][3] = scanner.nextInt();
        }

        solveTimeRiftQueries(N, M, A, updates, Q, queries);
        scanner.close();
    }
}