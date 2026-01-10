import java.util.*;

class Main {
    public static int parenthesisDepth(String s){
        int depth = 0;
        int d = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                d++;
            }
            depth = Math.max(depth,d);
            if(ch == ')'){
                d--;
            }
        }
        return depth;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        System.out.print(parenthesisDepth(s));
    }
}