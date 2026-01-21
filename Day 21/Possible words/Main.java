import java.util.*;

public class Main {
    static String[] letters = {"", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static void solve(int index, String digits, StringBuilder sb, List<String> result){
        if(index == digits.length()){
            result.add(sb.toString());
            return;
        }

        int number = digits.charAt(index) - '0';
        String curr = letters[number];
        
        for(char ch : curr.toCharArray()){
            sb.append(ch);

            solve(index+1,digits,sb,result);
            
            sb.deleteCharAt(sb.length()-1);
        }

    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        solve(0, digits, new StringBuilder(), result);

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String digits = scanner.nextLine().trim();

        List<String> result = letterCombinations(digits);

        Collections.sort(result);

        for (String combination : result) {
            System.out.print(combination + " ");
        }
    }
}