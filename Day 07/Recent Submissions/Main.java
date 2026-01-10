import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        int maxSize = 0;
        for (int i = 0; i < N; i++) {
            int t = sc.nextInt();
            if (!q.isEmpty() && q.peek() <= t-5000) {
                q.poll();
            }
            q.offer(t);
            maxSize = Math.max(maxSize, q.size());
        }
        System.out.println(maxSize);
    }
}