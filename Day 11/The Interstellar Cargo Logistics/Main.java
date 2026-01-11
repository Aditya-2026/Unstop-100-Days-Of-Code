import java.util.*;

public class Main {
    public static int minFuelConsumption(int[] weights, int k) {
        int n = weights.length;
        if (k > n) {
            return -1;
        }

        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, weights[i]);
            dp[i][1] = max;
        }

        for (int starship = 2; starship <= k; starship++) {
            for (int i = 0; i <= n - starship; i++) {
                int currMax = 0;
                for (int j = i; j < n - (starship - 1); j++) {
                    currMax = Math.max(currMax, weights[j]);
                    dp[i][starship] = Math.min(
                        dp[i][starship],
                        currMax + dp[j + 1][starship - 1]
                    );
                }
            }
        }

        return dp[0][k];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();
        System.out.println(minFuelConsumption(weights, k));
    }
}
