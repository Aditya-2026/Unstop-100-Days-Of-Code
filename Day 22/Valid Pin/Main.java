import java.util.Scanner;

public class Main {
    static final long MOD = 1000000007;

    static long modPow(long base,long exponent){
        long result = 1;
        base %= MOD;

        while(exponent>0){
            if((exponent & 1) == 1){
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent = (exponent >> 1);
        }

        return result;
    } 

    static long calculateValidPins(long n) {
        long evenPositions = (n+1)/2;
        long oddPositions = (n)/2;

        long evenWays = modPow(5,evenPositions);
        long oddWays = modPow(4,oddPositions);

        return (evenWays * oddWays) % MOD;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long result = calculateValidPins(n);
        System.out.println(result);
        scanner.close();
    }
}
