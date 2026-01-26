import java.util.Scanner;

public class Main {
    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public static void calculateLcmWithConstraints(int n, int[][] gears) {
        long currentLCM = 1;

        for (int i = 0; i < n; i++) {
            currentLCM = lcm(currentLCM, gears[i][0]);

            if (currentLCM > Long.MAX_VALUE / 2) {
                System.out.println(-1);
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            if (currentLCM % gears[i][1] == 0) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(currentLCM);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] gears = new int[n][2];
        for (int i = 0; i < n; i++) {
            gears[i][0] = scanner.nextInt();
            gears[i][1] = scanner.nextInt();
        }
        calculateLcmWithConstraints(n, gears);
        scanner.close();
    }
}
