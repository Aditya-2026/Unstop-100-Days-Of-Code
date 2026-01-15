import java.util.Scanner;

public class Main {
    public static long calculateMinThread(int M, int N, int T) {
        int min = Math.min(M,N);
        int turns = 2*(min-1);
        int turnsCost = T*turns;
        int stiches = M*N;

        return stiches + turnsCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int T = scanner.nextInt();

        long result = calculateMinThread(M, N, T);

        System.out.println(result);
        scanner.close();
    }
}