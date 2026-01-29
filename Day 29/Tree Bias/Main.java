import java.util.*;

public class Main {
    public static int sumOfDepths(int n, List<int[]> edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[n+1];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{1,0});
        vis[1] = true;

        int ans = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int node = curr[0];
            int depth = curr[1];

            ans += depth;

            for(int nei : adj.get(node)){
                if(!vis[nei]){
                    vis[nei] = true;
                    q.add(new int[]{nei, depth+1});
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n - 1; ++i) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            edges.add(new int[]{a, b});
        }
        int result = sumOfDepths(n, edges);
        System.out.println(result);
        scanner.close();
    }
}