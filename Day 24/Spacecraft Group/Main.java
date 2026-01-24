import java.util.*;

public class Main {

    public static int spaceshipFleets(int k, int[] pos, int[] speed) {
        int n = pos.length;

        double[][] ships = new double[n][2];

        for (int i = 0; i < n; i++) {
            ships[i][0] = pos[i];
            ships[i][1] = (double)(k - pos[i]) / speed[i];
        }

        Arrays.sort(ships, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double maxTime = 0;

        for (int i = 0; i < n; i++) {
            if (ships[i][1] > maxTime) {
                fleets++;
                maxTime = ships[i][1];
            }
        }

        return fleets;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] pos = new int[n];
        int[] speed = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            speed[i] = scanner.nextInt();
        }
        int result = spaceshipFleets(k, pos, speed);
        System.out.println(result);
        scanner.close();
    }
}
