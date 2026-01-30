
import java.util.*;

public class Main {
    static final int MOD = 1000000007;
    public static int ways(int sum) {
        int dp[] = new int[sum+1];
        dp[0] = 1;

        for(int i=1;i<=sum;i++){
            long ways = 0;
            for(int j=1;j<=6;j++){
                if(j <= i){
                    ways = (ways + dp[i-j]) % MOD;
                }else{
                    break;
                }
            }
            dp[i] = (int)ways;
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = ways(n);
        System.out.println(result);
        scanner.close();
    }
}
