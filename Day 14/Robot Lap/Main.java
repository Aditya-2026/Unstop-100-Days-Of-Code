import java.util.Scanner;

class Main {
    public static String carReturnsToOrigin(int n, String moves) {
        int x = 0, y = 0;

        for (int i = 0; i < n; i++) {
            char c = moves.charAt(i);
            if (c == 'U') y++;
            else if (c == 'D') y--;
            else if (c == 'L') x--;
            else if (c == 'R') x++;
        }

        return (x == 0 && y == 0) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String moves = scanner.next();
        scanner.close();
        
        String result = carReturnsToOrigin(n, moves);
        System.out.println(result);
        scanner.close();
    }
}