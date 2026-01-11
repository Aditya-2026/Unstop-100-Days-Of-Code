import java.util.*;

public class Main {
    public static int calculateTotalCost(int k, int n, int m, List<int[]> graph) {
        if (m == 0) {
            return 0;
        }
        Map<Integer,List<Integer>> adj = new HashMap<>();

        for(int[] edge : graph){
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u,x-> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v,x-> new ArrayList<>()).add(u);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited.add(0);

        int count = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(node != 0 && node % m == 0){
                count++;
            }

            for(int nei : adj.getOrDefault(node,Collections.emptyList())){
                if(!visited.contains(nei)){
                    visited.add(nei);
                    queue.add(nei);
                }
            }
        }

        return count * k;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int k = scanner.nextInt();  // Price of the bulb
        int n = scanner.nextInt();  // Total number of bulbs
        int m = scanner.nextInt();  // Number of bulbs divisible by m
        int lenGraph = scanner.nextInt();  // Length of the 2D array
        
        List<int[]> graph = new ArrayList<>();
        for (int i = 0; i < lenGraph; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.add(new int[]{u, v});
        }
        
        // Call user logic function and print the output
        int totalCost = calculateTotalCost(k, n, m, graph);
        System.out.println(totalCost);
    }
}