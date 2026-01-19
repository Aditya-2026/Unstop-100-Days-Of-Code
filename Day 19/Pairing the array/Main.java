import java.util.*;

public class Main {
    public static int gcd(int a, int b) {
        if(b==0) return a;

        return gcd(b, a % b);
    }
    public static long count_pairs_divisible_by_k(int k, int n, int[] arr) {
        
        Map<Integer, Long> freq = new HashMap<>();

        for (int num : arr) {
            int g = gcd(num, k);
            freq.put(g, freq.getOrDefault(g, 0L) + 1);
        }

        long count = 0;
        Integer[] keys = freq.keySet().toArray(new Integer[0]);

        for (int i = 0; i < keys.length; i++) {
            for (int j = i; j < keys.length; j++) {

                long g1 = keys[i];
                long g2 = keys[j];

                if ((g1 * g2) % k == 0) {
                    if (i == j) {
                        long c = freq.get(keys[i]);
                        count += c * (c - 1) / 2;
                    } else {
                        count += freq.get(keys[i]) * freq.get(keys[j]);
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        long result = count_pairs_divisible_by_k(k, n, arr);
        System.out.println(result);
        scanner.close();
    }
}