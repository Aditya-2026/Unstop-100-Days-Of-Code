import java.util.*;

class Main {
    public static void solve(int N,int k,int[][] coordinates){
        Arrays.sort(coordinates,(a,b)->Integer.compare(a[2],b[2]));
        for(int i=0;i<k;i++){
            System.out.print(coordinates[i][0] +" "+ coordinates[i][1]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] coordinates = new int[N][3];
        for(int i=0;i<N;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int dist = x*x + y*y;
            coordinates[i][0] = x;
            coordinates[i][1] = y;
            coordinates[i][2] = dist;
        }
        int k = sc.nextInt();

        solve(N,k,coordinates);
    }
}