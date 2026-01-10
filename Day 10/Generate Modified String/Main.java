import java.util.Scanner;

public class Main {
    static boolean isPrime(int n) {
        return n == 2 || n == 3 || n == 5 || n == 7;
    }

    public static void modifyString(int n, String s) {
        int primeSum = 0, primeCount = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                int d = ch - '0';

                if (isPrime(d)) {
                    primeSum += d;
                    primeCount++;
                }

            }
        }

        int unique = 0;
        boolean hasPrime = primeCount > 0;

        if (hasPrime) {
            unique = primeSum / primeCount;
        }

        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                int d = ch - '0';
                int index = hasPrime ? (d % unique) : d;
                result.append((char) ('a' + index));
            } else {
                result.append(ch);
            }
        }

        System.out.println(result.toString());

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        modifyString(n, s);
    }
}