import java.util.*;

public class Main {
    static char[][] charGrid;
    static Set<String> set;
    static int N;
    static int M;
    static final int MOD = 1000000007;

    public static void solve(int i,int j,StringBuilder sb){
        sb.append(charGrid[i][j]);

        if(i == N-1 && j == M-1){
            set.add(sb.toString());
            sb.deleteCharAt(sb.length()-1);
            return;
        }

        if(i+1<N) solve(i+1,j,sb);
        if(j+1<M) solve(i,j+1,sb);

        sb.deleteCharAt(sb.length()-1);
    }

    public static int countDistinctColorSequences(int n, int m, String[] grid) {
        N = n;
        M = m;
        charGrid = new char[N][M];
        set = new HashSet<>();
        for(int i=0;i<n;i++){
            charGrid[i] = grid[i].toCharArray();
        }
        solve(0,0,new StringBuilder());
        return set.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();
        String[] grid = new String[N];
        for (int i = 0; i < N; i++) {
            grid[i] = scanner.nextLine();
        }
        int result = countDistinctColorSequences(N, M, grid);
        System.out.println(result);
        scanner.close();
    }
}
