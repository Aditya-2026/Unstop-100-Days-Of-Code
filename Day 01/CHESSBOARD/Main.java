import java.util.Scanner;

public class Main {
    public static String determineColor(String s) {
        int a = s.charAt(0)-'a'+1;
        int b = s.charAt(1)-'0';
        if(((a&1)==1 && (b&1)==1) || ((a&1) ==0 && (b&1)==0)){
            return "Black";
        }else{
            return "White";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        String result = determineColor(s);
        System.out.println(result);
    }
}