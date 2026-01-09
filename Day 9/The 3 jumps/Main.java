import java.util.*;

public class Main {
    public static int minCost(int[] v) {
        int n = v.length;
        int dp[] = new int[n];
        dp[0] = 0;

        for(int i=1;i<n;i++){

            int way1 = Math.abs(v[i] - v[i-1]) + dp[i-1];
            int way2 = Integer.MAX_VALUE;
            if(i>1){
                way2 = Math.abs(v[i] - v[i-2]) + dp[i-2];
            }
            int way3 = Integer.MAX_VALUE;
            if(i>2){
                way3 = Math.abs(v[i] - v[i-3]) + dp[i-3];
            }

            dp[i] = Math.min(way1,Math.min(way2,way3));
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = scanner.nextInt();
        }

        int result = minCost(v);
        System.out.println(result);
    }
}