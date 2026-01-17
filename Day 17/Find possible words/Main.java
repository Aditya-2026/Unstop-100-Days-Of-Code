import java.util.*;

public class Main {
    public static int count_characters(List<String> words, String chars) {
        int[] freq = new int[26];
        for(int i=0;i<chars.length();i++){
            freq[chars.charAt(i)-'a']++;
        }

        int totLength = 0;

        for(String str : words){

            int[] temp = freq.clone();
            boolean isGood = true;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                if(temp[ch - 'a'] == 0){
                    isGood = false;
                    break;
                }
                temp[ch -'a']--;
            }
            if(isGood){
                totLength += str.length();
            }
        }
        return totLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine());
        }
        String chars = scanner.nextLine();
        
        int result = count_characters(words, chars);
        System.out.println(result);
        scanner.close();
    }
}