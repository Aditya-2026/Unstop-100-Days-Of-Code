import java.util.*;

class Main {
    static boolean[][] vis;
    static int topRow, bottomRow;
    static int topLeftCol, bottomRightCol;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void bfs(int sr, int sc, int n, int m, int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        vis[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (r < topRow) {
                topRow = r;
                topLeftCol = c;
            } else if (r == topRow) {
                topLeftCol = Math.min(topLeftCol, c);
            }

            if (r > bottomRow) {
                bottomRow = r;
                bottomRightCol = c;
            } else if (r == bottomRow) {
                bottomRightCol = Math.max(bottomRightCol, c);
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                    !vis[nr][nc] && grid[nr][nc] == 1) {
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }

    public static void user_logic(int n, int m, int[][] grid) {
        vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {

                    topRow = i;
                    bottomRow = i;
                    topLeftCol = j;
                    bottomRightCol = j;

                    bfs(i, j, n, m, grid);

                    System.out.println(
                        topRow + " " + topLeftCol + " " +
                        bottomRow + " " + bottomRightCol
                    );
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        user_logic(n, m, grid);
        sc.close();
    }
}
