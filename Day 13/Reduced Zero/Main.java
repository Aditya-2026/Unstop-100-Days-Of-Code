import java.util.Scanner;

public class Main {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int user_logic(int n) {
        if(isPrime(n)){
            return 1;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return n / i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int result = user_logic(n);
        // Some test cases are incorrect
        System.out.println(result);
    }
}