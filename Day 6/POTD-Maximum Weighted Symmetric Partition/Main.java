import java.util.Scanner;

public class Main {
    public static long maxWeightedScore(String S, int[] weights) {
        int n = S.length();
        int w[] = new int[n];
        for(int i=0;i<n;i++){
            w[i] = weights[S.charAt(i)-'a'];
        }

        int prefixSum[] = new int[n+1];

        for(int i=0;i<n;i++){
            prefixSum[i+1] = prefixSum[i] + w[i];
        }

        boolean[][] isPalindrome = new boolean[n][n];
        for(int i=0;i<n;i++){
            isPalindrome[i][i] = true;
        }

        for(int len=2;len<=n;len++){
            for(int i= 0;i+len-1<n;i++){
                int j = i+len-1;
                if(S.charAt(i)==S.charAt(j)){
                    if(len==2 || isPalindrome[i+1][j-1]){
                        isPalindrome[i][j] = true;
                    }
                }
            }
        }

        long[] dp = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    long sum = prefixSum[i] - prefixSum[j];
                    long len = i - j;
                    long score = len * sum;
                    dp[i] = Math.max(dp[i], dp[j] + score);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); 
        scanner.nextLine(); 

        String S = scanner.nextLine(); 

        int[] weights = new int[26];
        for (int i = 0; i < 26; ++i) {
            weights[i] = scanner.nextInt();
        }

        long result = maxWeightedScore(S, weights);
        System.out.println(result); 

        scanner.close();
    }
}
