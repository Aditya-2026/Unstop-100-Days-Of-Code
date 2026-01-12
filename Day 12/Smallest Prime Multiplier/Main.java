import java.util.*;

public class Main {
    public static long GCD(long p,long n){
        if(n==0){
            return p;
        }
        return GCD(n,p%n);
    }
    public static long computeX(long p, long n) {
        return (p/GCD(p,n))*n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long p = scanner.nextLong();
        long n = scanner.nextLong();
        
        long result = computeX(p, n);
        System.out.println(result);
        scanner.close();
    }
}