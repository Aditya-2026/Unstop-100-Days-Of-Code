import java.util.*;

public class Main {

    @SuppressWarnings("unchecked")
    public static void frequency_sort(String s) {
        int n = s.length();
        if (n == 0) {
            System.out.println("");
            return;
        }

        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;

        for (char ch : s.toCharArray()) {
            int f = map.getOrDefault(ch, 0) + 1;
            map.put(ch, f);
            maxFreq = Math.max(maxFreq, f);
        }

        ArrayList<Character>[] buckets = new ArrayList[maxFreq + 1];

        for (char ch : map.keySet()) {
            int f = map.get(ch);
            if (buckets[f] == null) {
                buckets[f] = new ArrayList<>();
            }
            buckets[f].add(ch);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = maxFreq; i >= 1; i--) {
            if (buckets[i] != null) {
                Collections.sort(buckets[i], Collections.reverseOrder());

                for (char ch : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(ch);
                    }
                }
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        frequency_sort(s);
        scanner.close();
    }
}