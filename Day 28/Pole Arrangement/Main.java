import java.util.*;

public class Main {

    public static void changeLongest(int[] arr, int x) {
        int max = 0;
        for (int v : arr) {
            max = Math.max(max, v);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                arr[i] = Math.max(0, arr[i] - x);
            }
        }
    }

    public static boolean poleArrangement(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;

        int[] leftMin = new int[n];
        leftMin[0] = arr[0];

        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], arr[i]);
        }

        for (int j = 1; j < n - 1; j++) {
            if (leftMin[j - 1] < arr[j]) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[k] > leftMin[j - 1] && arr[k] < arr[j]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; ++i) {
            arr[i] = scanner.nextInt();
        }

        changeLongest(arr, x);

        boolean result = poleArrangement(arr);
        System.out.println(result ? 1 : 0);
        scanner.close();
    }
}
