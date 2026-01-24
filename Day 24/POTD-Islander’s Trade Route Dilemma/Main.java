import java.util.*;

public class Main {

    static class Link {
        int v, cost;
        Link(int v, int c) {
            this.v = v;
            this.cost = c;
        }
    }

    static class PathState {
        int pos;
        long t;
        Map<Integer, Long> taken;

        PathState(int p, long t, Map<Integer, Long> map) {
            this.pos = p;
            this.t = t;
            this.taken = map;
        }
    }

    public static int minimum_freshness_threshold(
            int n, int m, int k, int[] goodsArr, int[][] edges) {

        List<List<Link>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            int w = e[2];
            adj.get(u).add(new Link(v, w));
        }

        Set<Integer> unique = new HashSet<>();
        for (int g : goodsArr) unique.add(g);
        if (unique.size() < k) return -1;

        boolean[] seen = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        seen[0] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (Link l : adj.get(u)) {
                if (!seen[l.v]) {
                    seen[l.v] = true;
                    q.add(l.v);
                }
            }
        }
        if (!seen[n - 1]) return -1;

        PriorityQueue<PathState> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a.t));

        Map<Integer, Long> startGoods = new HashMap<>();
        startGoods.put(goodsArr[0], 0L);
        pq.add(new PathState(0, 0L, startGoods));

        long best = Long.MAX_VALUE;

        while (!pq.isEmpty()) {
            PathState cur = pq.poll();

            if (cur.pos == n - 1 && cur.taken.size() >= k) {
                List<Long> times = new ArrayList<>(cur.taken.values());
                times.sort(Collections.reverseOrder());
                long x = cur.t - times.get(k - 1);
                best = Math.min(best, x);
                continue;
            }

            for (Link l : adj.get(cur.pos)) {
                long nt = cur.t + l.cost;
                Map<Integer, Long> nextMap = new HashMap<>(cur.taken);
                nextMap.putIfAbsent(goodsArr[l.v], nt);

                if (nextMap.size() > k + 2) continue;

                pq.add(new PathState(l.v, nt, nextMap));
            }
        }

        return best == Long.MAX_VALUE ? -1 : (int) best;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[] goods = new int[n];
        for (int i = 0; i < n; i++) {
            goods[i] = scanner.nextInt();
        }

        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
            edges[i][2] = scanner.nextInt();
        }

        int result = minimum_freshness_threshold(n, m, k, goods, edges);
        System.out.println(result);
        scanner.close();
    }
}
