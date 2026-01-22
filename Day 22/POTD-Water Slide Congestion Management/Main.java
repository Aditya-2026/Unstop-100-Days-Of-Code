import java.util.Scanner;

public class Main {

    public static int maxTotalPopularity(int[] P, int N) {
        if(N==1) return Math.max(P[0],0);
        int prev2 = Math.max(P[0],0);
        int prev1 = Math.max(0,Math.max(P[0],P[1]));

        for(int i=2;i<N;i++){
            int curr = Math.max(prev2 + P[i] , prev1);

            prev2 = prev1;
            prev1 = curr;
        } 
        return prev1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
        }

        int result = maxTotalPopularity(P, N);
        System.out.println(result);

        sc.close();
    }
}
