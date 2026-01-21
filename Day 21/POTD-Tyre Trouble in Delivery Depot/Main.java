import java.util.Scanner;

public class Main {
    public static int countEligibleBikes(int[][] tyres, int N, int T) {
        int count = 0;
        for(int i=0;i<N;i++){
            if(tyres[i][0]<=T || tyres[i][1]<=T){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int T = scanner.nextInt();

        int[][] tyres = new int[N][2];
        for (int i = 0; i < N; ++i) {
            tyres[i][0] = scanner.nextInt();
            tyres[i][1] = scanner.nextInt();
        }

        int result = countEligibleBikes(tyres, N, T);
        System.out.println(result);
        scanner.close();
    }
}
