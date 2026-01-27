import java.util.*;

public class Main {
    public static int userLogic(int n, List<int[]> positionsCards) {
        List<int[]> left = new ArrayList<>();
        List<int[]> right = new ArrayList<>();

        for (int[] pc : positionsCards) {
            if (pc[0] < 0) left.add(pc);
            else if (pc[0] > 0) right.add(pc);
        }

        left.sort((a, b) -> b[0] - a[0]);
        right.sort(Comparator.comparingInt(a -> a[0]));

        int sum1 = simulate(right, left);

        int sum2 = simulate(left, right);

        return Math.max(sum1, sum2);
    }

    private static int simulate(List<int[]> first, List<int[]> second) {
        int i = 0, j = 0;
        int sum = 0;
        boolean turnFirst = true;

        while (true) {
            if (turnFirst) {
                if (i < first.size()) {
                    sum += first.get(i++)[1];
                } else break;
            } else {
                if (j < second.size()) {
                    sum += second.get(j++)[1];
                } else break;
            }
            turnFirst = !turnFirst;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> positionsCards = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int pi = scanner.nextInt();
            int ci = scanner.nextInt();
            positionsCards.add(new int[]{pi, ci});
        }
        int result = userLogic(n, positionsCards);
        System.out.println(result);
        scanner.close();
    }
}