import java.util.Scanner;

public class Main {
    public static int user_logic(int n, String s) {
        int freq[] = new int[26];

        int need = 0;
        for(char ch : s.toCharArray()){
            if(ch >= 'A' && ch <= 'Z'){
                if(freq[ch - 'A'] > 0) freq[ch - 'A']--;
                else need++;
            }else{
                freq[ch - 'a']++;
            }
        }
        return need;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();

        int result = user_logic(n, s);
        System.out.println(result);
        scanner.close();
    }
}