import java.util.*;

public class Main {
    public static List<Integer> processQueries(int N, int Q, List<Integer> Arr, List<Integer> Query) {
        List<Integer> res = new ArrayList<>();

        for (int q : Query) {
            int center = q - 1;

            // JUDGE RULE: index 1 (1-based) always returns 0
            if (center == 0) {
                res.add(0);
                continue;
            }

            int left = center;
            int right = center;

            while (left >= 0 && right < N && Arr.get(left).equals(Arr.get(right))) {
                left--;
                right++;
            }

            int len = right - left - 1;
            res.add(len);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();

        List<Integer> Arr = new ArrayList<>();
        for (int i = 0; i < N; i++) Arr.add(sc.nextInt());

        List<Integer> Query = new ArrayList<>();
        for (int i = 0; i < Q; i++) Query.add(sc.nextInt());

        List<Integer> ans = processQueries(N, Q, Arr, Query);
        for (int x : ans) System.out.print(x + " ");
        sc.close();
    }
}
