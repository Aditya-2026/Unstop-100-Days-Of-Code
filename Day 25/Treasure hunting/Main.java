import java.util.*;

class Main {
    public static long user_logic(int n, int[] a, int[] b) {
        int size = 1 << n;

        long[] dp = new long[size];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        for (int mask = 0; mask < size; mask++) {
            int k = Integer.bitCount(mask);
            if (k >= n) continue;

            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) == 0) {
                    int nextMask = mask | (1 << j);
                    dp[nextMask] = Math.min(
                        dp[nextMask],
                        dp[mask] + (a[k] ^ b[j])
                    );
                }
            }
        }

        return dp[size - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        long result = user_logic(n, a, b);
        System.out.println(result);
        sc.close();
    }
}