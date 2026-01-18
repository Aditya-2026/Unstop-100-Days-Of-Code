import java.util.*;

public class Main {
    public static int solve(int p,int f,int[][] dp){
        if(p==0) return dp[p][f] = 0;
        if(p==1 || f==1 || f==0) return dp[p][f] = f;

        if(dp[p][f] != -1) return dp[p][f];

        int low = 1;
        int high = f;
        int ans = Integer.MAX_VALUE;

        while(low<=high){
            int mid = low + (high-low)/2;

            int fail = solve(p-1,mid-1,dp);
            int notFail = solve(p,f-mid,dp);

            int temp = 1 + Math.max(fail,notFail);

            ans = Math.min(ans,temp);
            if(fail>notFail){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return dp[p][f] = ans; 
    }
    public static int minParachutes(int k, int n) {
        int[][] dp = new int[k+1][n+1];
        for(int[] row :dp){
            Arrays.fill(row,-1);
        }

        return solve(k,n,dp);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); 
        int k = scanner.nextInt();
        
        int result = minParachutes(k, n);
        System.out.println(result);
        scanner.close();
    }
}