import java.util.Scanner;

public class Main {
    public static int computeTotalTime(int N, int[] fabric, int[] temp) {
        int totalTimeUnits = 1;
        for(int i=1;i<N;i++){
            int currTimeUnits = 1;
            
            if(fabric[i] != fabric[i-1]){
                currTimeUnits += Math.abs(temp[i]-temp[i-1]);
            }

            totalTimeUnits += currTimeUnits;
        }
        return totalTimeUnits;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] fabric = new int[N];
        int[] temp = new int[N];
        
        for (int i = 0; i < N; ++i) {
            fabric[i] = sc.nextInt();
        }
        
        for (int i = 0; i < N; ++i) {
            temp[i] = sc.nextInt();
        }
        
        int totalTime = computeTotalTime(N, fabric, temp);
        System.out.println(totalTime);
    }
}
