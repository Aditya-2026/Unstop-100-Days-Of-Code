import java.util.Scanner;

public class Main {
    public static int user_logic(int A, int B, int C) {
        return A ^ (B & C);  
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();
            int result = user_logic(A, B, C);
            System.out.println(result);
        }
        scanner.close();
    }
}