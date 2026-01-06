import java.util.*;

public class Main {
    public static void find_youngest_member(int n, int m, int[][] gifts) {
        if(n==1){
            System.out.print(1);
            return;
        }
        int[] giftCount = new int[n+1];
        for(int i=0;i<m;i++){
            giftCount[gifts[i][1]]++;
            if(giftCount[gifts[i][1]] == n-1){
                System.out.print(gifts[i][1]);
                return;
            }
        }
        System.out.print(-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] gifts = new int[m][2];
        for (int i = 0; i < m; i++) {
            gifts[i][0] = scanner.nextInt();
            gifts[i][1] = scanner.nextInt();
        }
        find_youngest_member(n, m, gifts);
    }
}