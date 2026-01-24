import java.util.*;

public class Main {

    public static void validateStackSequences(
            int[] pushed,
            int[] popped,
            boolean[] isValid,
            int[] primeCount
    ) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;

        for (int x : pushed) {
            stack.push(x);

            while (!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        if (j == popped.length) {
            isValid[0] = true;
            primeCount[0] = 0;
            return;
        }

        isValid[0] = false;
        int remaining = stack.size();
        primeCount[0] = countPrimes(remaining);
    }

    private static int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] pushed = new int[n];
        int[] popped = new int[n];
        for (int i = 0; i < n; i++) {
            pushed[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            popped[i] = scanner.nextInt();
        }
        boolean[] isValid = new boolean[1];
        int[] primeCount = new int[1];
        validateStackSequences(pushed, popped, isValid, primeCount);
        if (isValid[0]) {
            System.out.println("true");
        } else {
            System.out.println("false");
            System.out.println(primeCount[0]);
        }
        scanner.close();
    }
}
