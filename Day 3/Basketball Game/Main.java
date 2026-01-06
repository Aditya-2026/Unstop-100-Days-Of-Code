import java.util.Scanner;
import java.util.*;

public class Main {
    public static int userLogic(String[] ops) {
        List<Integer> scores = new ArrayList<>();
        for(String curr : ops){
            if(curr.equals("+")){
                int rec = scores.get(scores.size()-1)+scores.get(scores.size()-2); 
                scores.add(rec);
            }else if(curr.equals("D")){
                int rec = 2 * scores.get(scores.size()-1);
                scores.add(rec);
            }else if(curr.equals("C")){
                scores.remove(scores.size()-1);
            }else{
                int rec = Integer.parseInt(curr);
                scores.add(rec);
            }
        }

        int sum = 0;
        for(int scr : scores){
            sum += scr;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] ops = new String[n];
        
        for (int i = 0; i < n; ++i) {
            ops[i] = scanner.next();
        }
        
        int result = userLogic(ops);
        System.out.println(result);
    }
}