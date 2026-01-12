import java.util.*;

public class Main {
    public static long minimumTimeToSolveProblems(int n, int k, int[] times) {
        if(k==0) return 0;
        if(n==0) return -1;

        Arrays.sort(times);

        if(times[0] == 0) return 0;

        long low = times[0];
        long high = (long)times[0] * k;
        long ans = -1;

        while(low<=high){
            long mid = low +(high-low)/2;
            long total = 0;

            for(int t:times){
                if(t>mid) break;
                total += (mid/t);
                if(total>=k) break;
            }

            if(total>=k){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        } 
        
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = scanner.nextInt();
        }
        long result = minimumTimeToSolveProblems(n, k, times);
        System.out.println(result);
    }
}