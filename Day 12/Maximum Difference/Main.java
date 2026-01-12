import java.util.*;

public class Main {
    public static int userLogic(int n, int[] arr) {
        int maxDiff = -1;
        int minElement = arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>minElement){
                maxDiff = Math.max(maxDiff,arr[i]-minElement);
            }
            minElement = Math.min(minElement,arr[i]);
        }
        
        return maxDiff;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();        
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(userLogic(N, arr));
        }
        sc.close();
    }
}