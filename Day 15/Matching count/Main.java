import java.util.*;

public class Main {
    public static int matchingCount(List<List<String>> items, String ruleKey, String ruleValue) {
        int match = 0;
        int key;
        
        if (ruleKey.equals("type")) {
            key = 0;
        } else if (ruleKey.equals("color")) {
            key = 1;
        } else {
            key = 2;
        }

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).get(key).equals(ruleValue)) {
                match++;
            }
        }
        return match;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        List<List<String>> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            items.add(Arrays.asList(sc.nextLine().trim().split("\\s+")));
        }

        String ruleKey = sc.nextLine().trim();
        String ruleValue = sc.nextLine().trim();

        int result = matchingCount(items, ruleKey, ruleValue);
        System.out.println(result);
        sc.close();
    }
}
