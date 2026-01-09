import java.util.Scanner;

public class Main {
    public static int calculateFScore(int[] features, int N) {
        int[] prefXor = new int[N+1];
        for(int i=0;i<N;i++){
            prefXor[i+1] = prefXor[i]^features[i];
        }

        int totXor = 0;

        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
                int curr = prefXor[j+1] ^ prefXor[i];
                totXor ^= curr;
            }
        }

        return totXor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] features = new int[N];
        for (int i = 0; i < N; i++) {
            features[i] = sc.nextInt();
        }
        int result = calculateFScore(features, N);
        System.out.println(result);
        sc.close();
    }
}