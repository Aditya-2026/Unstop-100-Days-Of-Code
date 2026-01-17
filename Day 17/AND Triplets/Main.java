import java.util.*;

public class Main {
    public static int countTriplets(int n, int[] arr) {
        int MAX = 1 << 16;

        int[] freq = new int[MAX];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int pair = (arr[i] & arr[j]);
                freq[pair]++;
            }
        }

        int triplets = 0;

        for(int k=0;k<n;k++){
            for(int mask=0; mask<MAX; mask++){
                if((mask & arr[k]) == 0){
                    triplets += freq[mask];
                }
            }
        }
        
        return triplets;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int result = countTriplets(n, arr);
        System.out.println(result);
        scanner.close();
    }
}