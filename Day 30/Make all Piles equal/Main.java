import java.util.Scanner;

public class Main {
    public static long minOperations(long n) {
        return (n * n) / 4;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(minOperations(n));
        sc.close();
    }
}
