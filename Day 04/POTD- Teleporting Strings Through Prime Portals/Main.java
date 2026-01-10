import java.util.*;

public class Main {
    public static String obtainSmallestString(int N, int K, int M, String S, int[] P) {
        char[] arr = S.toCharArray();
        boolean[] isPortal = new boolean[N];
        for (int i = 0; i < K; i++) {
            isPortal[P[i] - 1] = true;
        }
        if (K == 0 || M == 0) {
            return S;
        }
        int operations = 0;

        for (int i = 0; i < N && operations < M; i++) {
            if (!isPortal[i]){
                continue;
            }
            char bestChar = arr[i];
            int bestIndex = -1;

            for (int j = i + 1; j < N; j++) {
                if (isPortal[j] && arr[j] > bestChar) {
                    bestChar = arr[j];
                    bestIndex = j;
                }
            }

            if (bestIndex != -1) {
                char temp = arr[i];
                arr[i] = arr[bestIndex];
                arr[bestIndex] = temp;
                operations++;
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine(); // consume newline
        String S = scanner.nextLine();
        int[] P = new int[K];
        for (int i = 0; i < K; i++) {
            P[i] = scanner.nextInt();
        }
        String result = obtainSmallestString(N, K, M, S, P);
        System.out.println(result);
    }
}