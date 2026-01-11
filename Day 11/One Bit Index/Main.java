import java.util.*;

public class Main {
    public static boolean isGood(int sum){
        return sum>0 && (sum & (sum-1)) == 0;
    }

    public static int count_good_indices(int n, int[] arr) {
        int count = 0;
        int sum = 0;

        for(int i=0;i<n;i++){
            sum += arr[i];
            if(isGood(sum)){
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int result = count_good_indices(n, arr);
        System.out.println(result);
    }
}