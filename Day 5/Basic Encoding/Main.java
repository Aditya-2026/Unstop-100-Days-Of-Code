import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine().trim());

        Map<Integer, Long> freq = new HashMap<>();

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            freq.put(B, freq.getOrDefault(B, 0L) + A);
        }

        if (freq.size() <= 1) {
            System.out.println(0);
            return;
        }

        long minFreq = Long.MAX_VALUE;
        long maxFreq = Long.MIN_VALUE;

        for (long f : freq.values()) {
            minFreq = Math.min(minFreq, f);
            maxFreq = Math.max(maxFreq, f);
        }

        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Long> e : freq.entrySet()) {
            if (e.getValue() == minFreq) {
                minNum = Math.min(minNum, e.getKey());
            }
            if (e.getValue() == maxFreq) {
                maxNum = Math.max(maxNum, e.getKey());
            }
        }

        System.out.println(Math.abs(maxNum - minNum));
    }
}