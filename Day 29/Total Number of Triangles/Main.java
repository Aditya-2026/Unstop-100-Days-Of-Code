import java.util.Scanner;

public class Main {
    public static long coloredCells(int n) {
        if (n == 0) return 0;

        long res = 1;
        for (int i = 0; i < n; i++) {
            res *= 3;
        }
        return (res - 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        long result = coloredCells(n);
        System.out.println(result);
        scanner.close();
    }
}