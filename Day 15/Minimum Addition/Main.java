import java.util.Scanner;

public class Main {
    private static int[] computeLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0;

        for (int i = 1; i < n; i++) {
            while (len > 0 && s.charAt(i) != s.charAt(len)) {
                len = lps[len - 1];
            }
            if (s.charAt(i) == s.charAt(len)) {
                len++;
            }
            lps[i] = len;
        }
        return lps;
    }

    public static int minimumAddition(String str) {
        char[] arr = str.toCharArray();
        arr[arr.length - 1] = 'c';
        String s = new String(arr);

        String rev = new StringBuilder(s).reverse().toString();
        String temp = s + "#" + rev;

        int[] lps = computeLPS(temp);

        return s.length() - lps[lps.length - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        int result = minimumAddition(input);
        System.out.println(result);
        scanner.close();
    }
}
