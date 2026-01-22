import java.util.*;

class Main {

    public static void solve(int n,int b,int c,int a,StringBuilder sb,List<String>result){
        if(sb.length() == n){
            result.add(sb.toString());
        }

        if(b>0){
            sb.append('B');
            solve(n,b-1,c,a,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }

        if(c>0){
            sb.append('C');
            solve(n,b,c-1,a,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }

        if(a>0){
            sb.append('A');
            solve(n,b,c,a-1,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }

    }

    public static List<String> find_possible_combinations(int n, int b, int c, int a) { 
        List<String> result = new ArrayList<String>();
        solve(n,b,c,a,new StringBuilder(),result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int a = sc.nextInt();
        
        List<String> result = find_possible_combinations(n, b, c, a);
        
        for (String combination : result) {
            System.out.println(combination);
        }
        sc.close();
    }
}
