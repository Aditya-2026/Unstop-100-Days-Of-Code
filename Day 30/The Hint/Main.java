import java.util.Scanner;

public class Main {
    public static int LongestConsecutiveCharacter(String s) {
        int hint = 1;
        int curr = 1;
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i-1) == s.charAt(i)){
                curr++;
                hint = Math.max(hint,curr);
            }else{
                curr = 1;
            }
        }
        return hint;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        scanner.close();
        
        int result = LongestConsecutiveCharacter(s);
        System.out.println(result);
    }
}