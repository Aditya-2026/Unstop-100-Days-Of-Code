import java.util.*;

class Main {
    public static void findKNearestPoints(List<int[]> points, int k, List<int[]> result) {

        List<int[]> distList = new ArrayList<>();

        for (int i = 0; i < points.size(); i++) {
            int x = points.get(i)[0];
            int y = points.get(i)[1];
            int dist = x * x + y * y;
            distList.add(new int[]{dist, i});
        }

        Collections.sort(distList, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        for (int i = 0; i < k; i++) {
            int idx = distList.get(i)[1];
            result.add(points.get(idx));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points.add(new int[] { x, y });
        }
        List<int[]> result = new ArrayList<>();
        findKNearestPoints(points, k, result);
        for (int[] point : result) {
            System.out.println(point[0] + " " + point[1]);
        }
        sc.close();
    }
}