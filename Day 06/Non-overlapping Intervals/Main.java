import java.util.*;

public class Main {

    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n ==0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int lastend = intervals[0][1];
        int removals = 0;

        for(int i=1;i<n;i++){
            if(intervals[i][0]<lastend){
                removals++;
            }else{
                lastend = intervals[i][1];
            }
        }
        return removals;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] intervals = new int[N][M];

        for (int i = 0; i < N; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        int result = eraseOverlapIntervals(intervals);
        System.out.println(result);
    }
}