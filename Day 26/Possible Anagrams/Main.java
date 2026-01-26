import java.util.*;

public class Main {
    public static List<Integer> findAnagramIndices(String secret1, String secret2) {
        List<Integer> result = new ArrayList<>();

        int n = secret1.length();
        int m = secret2.length();

        if (m > n) return result;

        int[] freqP = new int[26];
        int[] freqW = new int[26];

        for (char c : secret2.toCharArray()) {
            freqP[c - 'a']++;
        }

        for (int i = 0; i < m; i++) {
            freqW[secret1.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freqP, freqW)) {
            result.add(0);
        }

        for (int i = m; i < n; i++) {
            freqW[secret1.charAt(i) - 'a']++;
            freqW[secret1.charAt(i - m) - 'a']--;
            if (Arrays.equals(freqP, freqW)) {
                result.add(i - m + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secret1 = scanner.next();
        String secret2 = scanner.next();

        List<Integer> result = findAnagramIndices(secret1, secret2);

        if (result.isEmpty()) {
            System.out.println("Empty Array");
        } else {
            for (int idx : result) {
                System.out.print(idx + " ");
            }
        }
        scanner.close();
    }
}
