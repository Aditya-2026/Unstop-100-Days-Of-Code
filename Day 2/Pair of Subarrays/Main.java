import java.util.*;

public class Main {
    static class Interval {
        int l, r;
        Interval(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    public static int calculatePairs(int n, int[] arr) {
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        Map<Long, List<Interval>> bucket = new HashMap<>();

        for (int left = 1; left <= n; left++) {
            for (int right = left; right <= n; right++) {
                long val = prefix[right] - prefix[left - 1];
                bucket.computeIfAbsent(val, k -> new ArrayList<>())
                      .add(new Interval(left, right));
            }
        }

        int count = 0;

        for (List<Interval> group : bucket.values()) {
            int sz = group.size();
            for (int i = 0; i < sz; i++) {
                Interval a = group.get(i);
                for (int j = i + 1; j < sz; j++) {
                    Interval b = group.get(j);
                    if (a.r < b.l || b.r < a.l) {
                        count++;
                    }
                }
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
        System.out.println(calculatePairs(n, arr));
    }
}
