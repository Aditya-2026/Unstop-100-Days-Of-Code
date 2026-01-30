import java.util.Scanner;

public class Main {
    public static int user_logic(int l, int r) {
        if (l == r) return 0;
        int b = Math.max(l, (r / 2) + 1);
        return r - b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(user_logic(l, r));
        }
        scanner.close();
    }
}
