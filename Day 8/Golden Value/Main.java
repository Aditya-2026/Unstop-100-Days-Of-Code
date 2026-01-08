import java.util.*;

public class Main {
    public static long calculateGoldenValue(int[] arr, int n) {
        long SE =0,SO =0;
        int prefixXor = 0;

        long[][][] biCount = new long[31][2][2];

        for(int b = 0;b <= 30;b++){
            biCount[b][0][0] =1;
        }

        for(int i=0;i<n;i++){
            prefixXor = prefixXor ^ arr[i];
            int parity = (i+1) % 2;

            for(int b=0;b<=30;b++){
                int bit = (prefixXor >> b)&1;
                SO += biCount[b][1-parity][1-bit] * (1L << b);
                SE += biCount[b][parity][1-bit] * (1L << b);

                biCount[b][parity][bit]++;

            }
        }
        return Math.abs(SO-SE);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        long result = calculateGoldenValue(arr, n);
        System.out.println(result);
    }
}