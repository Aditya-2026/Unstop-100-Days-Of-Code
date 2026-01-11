import java.util.Scanner;

public class Main {
    public static int longestPalindromicSubstringLength(int n, String s) {
        boolean dp[][] = new boolean[n][n];
        int maxLength = 1;

        for(int i=0;i<n;i++){
            dp[i][i] = true;
        }

        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                maxLength = 2;
            }
        }

        for(int len=3; len<=n;len++){
            for(int i=0;i<n-len+1;i++){
                int j = i+len-1;

                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    maxLength = Math.max(maxLength,len);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        
        int result = longestPalindromicSubstringLength(n, s);
        System.out.println(result);
    }
}