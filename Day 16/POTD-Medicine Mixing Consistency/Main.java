import java.util.Scanner;

public class Main {
    public static long minEnergyCost(int[] T, int K) {
        int n = T.length;

        int L[] = new int[n];
        int R[] = new int[n];

        L[0] = T[0];
        for(int i=1;i<n;i++){
            L[i] = Math.min(T[i],L[i-1]+K);
        }

        R[n-1] = T[n-1];

        for(int i=n-2;i>=0;i--){
            R[i] = Math.min(T[i],R[i+1]+K);
        }

        long finalCost = 0;

        for(int i=0;i<n;i++){
            long cost = Math.min(L[i],R[i]);
            finalCost += (T[i] - cost);
        }

        return finalCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int[] T = new int[N];
        for (int i = 0; i < N; i++) {
            T[i] = scanner.nextInt();
        }

        long result = minEnergyCost(T, K);
        System.out.println(result);
        scanner.close();
    }
}