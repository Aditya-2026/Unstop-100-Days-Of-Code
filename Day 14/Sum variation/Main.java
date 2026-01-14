import java.util.*;

public class Main {
    public static int calculateSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;

        for (int x : nums) {
            sum += x;
            if (x > 0) {
                set.add(x);
            }
        }

        int missing = 1;
        while (set.contains(missing)) {
            missing++;
        }

        char firstDigit = Integer.toString(missing).charAt(0);
        int ascii = (int) firstDigit;

        return sum + ascii;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int result = calculateSum(nums);
        System.out.println(result);
        scanner.close();
    }
}