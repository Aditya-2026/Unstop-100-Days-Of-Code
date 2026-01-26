import java.util.*;

public class Main {
    public static void processDashes(int n, String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '_') {
                if (sb.length() == 0) {
                    System.out.println("-1");
                    return;
                }
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }

        if (sb.length() == 0) {
            System.out.println("-1");
        } else {
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        processDashes(n, s);
        sc.close();
    }
}
