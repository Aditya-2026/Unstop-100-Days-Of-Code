import java.util.Scanner;

public class Main {

    public static int countExpressibleNumbers(int X, int Y) {
        int count = 0;

        long pow2 = 1;
        while (pow2 <= Y) {
            long pow3 = 1;
            while (pow2 * pow3 <= Y) {
                long value = pow2 * pow3;
                if (value >= X) {
                    count++;
                }
                pow3 *= 3;
            }
            pow2 *= 2;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int Y = scanner.nextInt();

        int result = countExpressibleNumbers(X, Y);
        System.out.println(result);
        scanner.close();
    }
}
