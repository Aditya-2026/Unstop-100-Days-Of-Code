import java.util.Scanner;

public class Main {
    public static int countOnesInBinary(int N) {
        int totSetBits = 0;
        int[] setBits = new int[N+1];
        for(int i=1;i<=N;i++){
            setBits[i] = setBits[i/2] + (i%2);
            totSetBits += setBits[i];
        }
        return totSetBits;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); 

        int result = countOnesInBinary(N);
        System.out.println(result);
    }
}
