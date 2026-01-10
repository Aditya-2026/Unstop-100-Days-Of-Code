import java.util.*;

class Main {
    public static String isabPattern(String s) {
        int a = s.lastIndexOf('a');
        int b = s.indexOf('b');

        if (a < b || b == -1) {
            return "YES";
        }
        
        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.print(isabPattern(s));
    }
}