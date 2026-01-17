import java.util.Scanner;

public class Main {
    public static int maxSumObtainable(int[] nums, int difference) {
        int n = nums.length;
        int dp0[] = new int[n];
        int dp1[] = new int[n];

        int ans = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            dp0[i] = nums[i];
            dp1[i] = nums[i];
            for(int j=0;j<i;j++){
                if(Math.abs(nums[i] - nums[j]) <= difference){
                    dp0[i] = Math.max(dp0[i], dp0[j] + nums[i]);
                    dp1[i] = Math.max(dp1[i], dp1[j] + nums[i]);
                }else{
                    dp1[i] = Math.max(dp1[i], dp0[j] + nums[i]);
                }
            }

            ans = Math.max(ans, Math.max(dp0[i],dp1[i]));
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        int difference = scanner.nextInt();
        
        int result = maxSumObtainable(nums, difference);
        System.out.println(result);
        scanner.close();
    }
}
