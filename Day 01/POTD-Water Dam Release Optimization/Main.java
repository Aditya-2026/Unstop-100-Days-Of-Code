import java.util.Scanner;

public class Main {
    static int maxWaterRetained(int[] capacity, int[] initial, int lossPercent) {
        int n = capacity.length;
        for (int i = 0; i < n - 1; i++) {
            int send = initial[i];
            initial[i] = 0;
            if (send > 0) {
                int loss = (int)Math.ceil(send * (lossPercent / 100.0));
                int received = send - loss;
                int space = capacity[i + 1] - initial[i + 1];
                if (received > space) received = space;
                if (received < 0) received = 0;
                initial[i + 1] += received;
            }
        }
        return initial[n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] capacity = new int[N];
        int[] initial = new int[N];
        for (int i = 0; i < N; ++i) capacity[i] = scanner.nextInt();
        for (int i = 0; i < N; ++i) initial[i] = scanner.nextInt();
        int lossPercent = scanner.nextInt();
        int result = maxWaterRetained(capacity, initial, lossPercent);
        System.out.println(result);
        scanner.close();
    }
}