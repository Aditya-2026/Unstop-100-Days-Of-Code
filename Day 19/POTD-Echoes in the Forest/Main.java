import java.util.*;

public class Main {

    static class State {
        int x, y;
        int[][] block;
        int dist;

        State(int x, int y, int[][] block, int dist) {
            this.x = x;
            this.y = y;
            this.block = block;
            this.dist = dist;
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int N, M, K;
    static char[][] grid;

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    public static int bfs(int sx, int sy, int tx, int ty) {
        Queue<State> q = new LinkedList<>();
        int[][] startBlock = new int[N][M];
        q.offer(new State(sx, sy, startBlock, 0));

        Set<String> visited = new HashSet<>();

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.x == tx && cur.y == ty) return cur.dist;

            String key = cur.x + "," + cur.y + "," + Arrays.deepToString(cur.block);
            if (visited.contains(key)) continue;
            visited.add(key);

            int[][] nextBlockBase = new int[N][M];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                    nextBlockBase[i][j] = Math.max(0, cur.block[i][j] - 1);

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (!isValid(nx, ny)) continue;
                if (grid[nx][ny] == 'T') continue;
                if (nextBlockBase[nx][ny] > 0) continue;

                int[][] newBlock = new int[N][M];
                for (int i = 0; i < N; i++)
                    newBlock[i] = nextBlockBase[i].clone();

                if (grid[nx][ny] == 'E') {
                    for (int k = 0; k < 4; k++) {
                        int ax = nx + dx[k];
                        int ay = ny + dy[k];
                        if (isValid(ax, ay) && grid[ax][ay] != 'T') {
                            newBlock[ax][ay] = Math.max(newBlock[ax][ay], K);
                        }
                    }
                }

                q.offer(new State(nx, ny, newBlock, cur.dist + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        sc.nextLine();

        grid = new char[N][M];
        for (int i = 0; i < N; i++)
            grid[i] = sc.nextLine().toCharArray();

        int sx = sc.nextInt() - 1;
        int sy = sc.nextInt() - 1;
        int tx = sc.nextInt() - 1;
        int ty = sc.nextInt() - 1;

        System.out.println(bfs(sx, sy, tx, ty));
        sc.close();
    }
}
