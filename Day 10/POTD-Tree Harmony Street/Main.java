import java.util.*;

public class Main {
    static int maxAdditionalTrees(int[] P, int N) {
        int treesPlanted = 0;

        for (int i = 0; i < N; i++) {
            boolean left = (i == 0) || (P[i - 1] == 0);
            boolean right = (i == N - 1) || (P[i + 1] == 0);

            if (left && right && P[i] == 0) {
                treesPlanted++;
                P[i] = 1;
            }
        }

        return treesPlanted;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = scanner.nextInt();
        }

        // Call the user logic function and print the result
        int result = maxAdditionalTrees(P, N);
        System.out.println(result);
    }
}