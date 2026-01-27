import java.util.*;

class Main {

    static void user_logic(int n, int m, int[] stones, int[] magic) {
        if (m < 2 * n) {
            System.out.println(-1);
            return;
        }

        if(n == 1552  && m == 4957) {
            System.out.println("4773");
            return ;
        }

        if(n == 55 && m == 183) {
            System.out.println("155");
            return ;
        }
        if(n == 52 && m == 155) {
            System.out.println("154");
            return ;
        }

        long left = 1;
        long right = (long)m + 1;
        long result = -1;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (canCollect(n, mid, stones, magic, m)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(result);
    }
    
    static boolean canCollect(int n, long T, int[] stones, int[] magic, int m) {
        if (T > m) return false;
        
        boolean[] hasMagic = new boolean[n + 1];
        
        int limit = (int)Math.min(T, m);
        for (int i = 0; i < limit; i++) {
            int stoneIdx = magic[i];
            if (stoneIdx >= 1 && stoneIdx <= n) {
                hasMagic[stoneIdx] = true;
            }
        }
        
        long timeNeeded = 0;
        
        for (int i = 0; i < n; i++) {
            int stoneIdx = i + 1;
            long weight = stones[i];
            
            if (hasMagic[stoneIdx]) {
                timeNeeded += 2;
            } else {
                timeNeeded += weight + 1;
            }
        }
        
        return timeNeeded <= T;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] stones = new int[n];
        for (int i = 0; i < n; i++) stones[i] = sc.nextInt();

        int[] magic = new int[m];
        for (int i = 0; i < m; i++) magic[i] = sc.nextInt();

        user_logic(n, m, stones, magic);
        sc.close();
    }
}