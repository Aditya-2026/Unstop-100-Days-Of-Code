import java.util.*;

public class Main {
    public static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void user_logic(int n, int[] prices) {
        int longest = 0;
        int doublePrimeSum = 0;
        int curr = 1;
        int currSum = 0;
        if (isPrime(prices[0]) && isPrime(prices[0] + 2)) {
            currSum = prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                curr++;
                if (isPrime(prices[i]) && isPrime(prices[i] + 2)) {
                    currSum += prices[i];
                }
            } else {
                if (curr > longest) {
                    longest = curr;
                    doublePrimeSum = currSum;
                } else if (curr == longest) {
                    doublePrimeSum = Math.max(doublePrimeSum, currSum);
                }
                curr = 1;
                currSum = 0;
                if (isPrime(prices[i]) && isPrime(prices[i] + 2)) {
                    currSum = prices[i];
                }
            }
        }
        if (curr > longest) {
            longest = curr;
            doublePrimeSum = currSum;
        } else if (curr == longest) {
            doublePrimeSum = Math.max(doublePrimeSum, currSum);
        }
        System.out.println(longest + " " + doublePrimeSum);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        user_logic(n, prices);
    }
}