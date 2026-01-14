import java.util.*;

public class Main {
    public static void user_logic(int n, List<int[]> positions) {
        int[] xs = new int[n];
        int[] ys = new int[n];

        for (int i = 0; i < n; i++) {
            xs[i] = positions.get(i)[0];
            ys[i] = positions.get(i)[1];
        }

        Arrays.sort(xs);
        Arrays.sort(ys);

        int xLow = xs[(n - 1) / 2];
        int xHigh = xs[n / 2];
        int yLow = ys[(n - 1) / 2];
        int yHigh = ys[n / 2];

        long countX = (long) xHigh - xLow + 1;
        long countY = (long) yHigh - yLow + 1;

        System.out.println(countX * countY);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> positions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            positions.add(new int[]{x, y});
        }
        
        // Call user logic function and print the output
        user_logic(n, positions);
        sc.close();
    }
}