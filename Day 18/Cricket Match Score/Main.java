import java.util.*;

public class Main {
    public static boolean userLogic(int n, int[] runs) {
        int maxReach = 0;
        for (int i = 0; i < n; i++) {
            if (i > maxReach) {
                return false;
            }

            maxReach = Math.max(maxReach, i + runs[i]);

            if (maxReach >= n - 1) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] runs = new int[n];
        for (int i = 0; i < n; ++i) {
            runs[i] = scanner.nextInt();
        }

        boolean result = userLogic(n, runs);
        System.out.println(result ? "true" : "false");
        scanner.close();
    }
}
