import java.util.Scanner;

public class Main {
    public static int FirstWrongDecision(String s) {
        return s.indexOf('W');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(FirstWrongDecision(str));
        scanner.close();
    }
}