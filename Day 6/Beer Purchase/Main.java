import java.util.*;

public class Main {

    public static long maxBottle(long[] a, int n, long x) {
        Arrays.sort(a);
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + a[i];
        }
        long totalBottles = 0;
        for (int k = 1; k <= n; k++) {
            if (prefixSum[k] > x) break;
            long maxDays = (x - prefixSum[k]) / k + 1;
            totalBottles += maxDays;
        }
        return totalBottles;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long x = sc.nextLong();

        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        System.out.println(maxBottle(a, n, x));
        sc.close();
    }
}
