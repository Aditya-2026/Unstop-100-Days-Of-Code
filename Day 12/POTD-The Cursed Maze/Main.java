import java.util.Scanner;

public class Main {
    public static int userLogic(int[][] maze) {
        int points=0;
        for(int[] arr : maze){
            for(int x : arr ){
                points += ((x>0)? x : 0);
            }
        }
        return points; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] maze = new int[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                maze[i][j] = scanner.nextInt();
            }
        }
        int result = userLogic(maze);
        System.out.println(result);
        scanner.close();
    }
}