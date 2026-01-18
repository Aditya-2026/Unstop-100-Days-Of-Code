import java.util.*;

public class Main {

    public static int countSafeZones(char[][] grid, int n, int m) {
        boolean[][] destroyed = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            int lastWall = -1;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'W') lastWall = j;
                else if (grid[i][j] == 'B') {
                    for (int k = lastWall + 1; k < j; k++) {
                        if (grid[i][k] == '0') destroyed[i][k] = true;
                    }
                }
            }

            lastWall = m;
            for (int j = m - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') lastWall = j;
                else if (grid[i][j] == 'B') {
                    for (int k = j + 1; k < lastWall; k++) {
                        if (grid[i][k] == '0') destroyed[i][k] = true;
                    }
                }
            }
        }

        for (int j = 0; j < m; j++) {
            int lastWall = -1;
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == 'W') lastWall = i;
                else if (grid[i][j] == 'B') {
                    for (int k = lastWall + 1; k < i; k++) {
                        if (grid[k][j] == '0') destroyed[k][j] = true;
                    }
                }
            }

            lastWall = n;
            for (int i = n - 1; i >= 0; i--) {
                if (grid[i][j] == 'W') lastWall = i;
                else if (grid[i][j] == 'B') {
                    for (int k = i + 1; k < lastWall; k++) {
                        if (grid[k][j] == '0') destroyed[k][j] = true;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0' && !destroyed[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = scanner.nextLine().toCharArray();
        }

        System.out.println(countSafeZones(grid, n, m));
        scanner.close();
    }
}
