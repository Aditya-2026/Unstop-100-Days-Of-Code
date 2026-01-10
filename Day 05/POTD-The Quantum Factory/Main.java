import java.util.*;

public class Main {
    static class Pair {
        int node;
        double energy;
        Pair(int node, double energy) {
            this.node = node;
            this.energy = energy;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] V = new int[N + 1];
        int[] K = new int[N + 1];
        for (int i = 1; i <= N; i++) V[i] = sc.nextInt();
        for (int i = 1; i <= N; i++) K[i] = sc.nextInt();
        double E = sc.nextDouble();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
        }

        double[] scale = new double[N + 1];
        for (int i = 1; i <= N; i++) {
            scale[i] = 1.0 - ((K[i] * V[i]) % 100) / 100.0;
        }

        double[] maxEnergy = new double[N + 1];
        Arrays.fill(maxEnergy, -1);

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(b.energy, a.energy)
        );

        maxEnergy[1] = E;
        pq.add(new Pair(1, E));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            double energy = curr.energy;

            if (energy < maxEnergy[u]) continue;

            for (int v : graph.get(u)) {
                double newEnergy = Math.max(0.0, energy * scale[u]);
                if (newEnergy > maxEnergy[v]) {
                    maxEnergy[v] = newEnergy;
                    pq.add(new Pair(v, newEnergy));
                }
            }
        }

        System.out.printf("%.6f", Math.max(0.0, maxEnergy[N]));
    }
}