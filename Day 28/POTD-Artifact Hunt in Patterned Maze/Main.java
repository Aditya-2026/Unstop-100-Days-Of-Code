import java.util.*;

public class Main {

    static int n, m;
    static String[] grid;
    static String pattern;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static int countPatternPaths(String[] g, String p) {
        grid = g;
        pattern = p;
        n = grid.length;
        m = grid[0].length();
        visited = new boolean[n][m];

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == pattern.charAt(0)) {
                    count += dfs(i, j, 0);
                }
            }
        }
        return count;
    }

    static int dfs(int x, int y, int idx) {
        if (grid[x].charAt(y) != pattern.charAt(idx)) return 0;
        if (idx == pattern.length() - 1) return 1;

        visited[x][y] = true;
        int paths = 0;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                paths += dfs(nx, ny, idx + 1);
            }
        }

        visited[x][y] = false;
        return paths;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        String[] grid = new String[n];
        for (int i = 0; i < n; i++) {
            grid[i] = scanner.nextLine();
        }

        String pattern = scanner.nextLine();
        System.out.println(countPatternPaths(grid, pattern));
        scanner.close();
    }
}
