import java.util.*;

public class Main {

    public static long count_parity_flipped_subarrays(int n, long k, int[] arr) {
        long count = 0;
        long prefSum = 0;
        Map<Long, Integer> map = new HashMap<>();

        map.put(0L, 1);

        for (int i = 0; i < n; i++) {
            long val;
            if (arr[i] % 2 == 0) {
                val = arr[i] + 1L;
            } else {
                val = arr[i] - 1L;
            }

            prefSum += val;
            count += map.getOrDefault(prefSum - k, 0);
            map.put(prefSum, map.getOrDefault(prefSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        int[] arr = new int[n];

        for (int i = 0; i < n; ++i) {
            arr[i] = scanner.nextInt();
        }

        long result = count_parity_flipped_subarrays(n, k, arr);
        System.out.println(result);
        scanner.close();
    }
}
