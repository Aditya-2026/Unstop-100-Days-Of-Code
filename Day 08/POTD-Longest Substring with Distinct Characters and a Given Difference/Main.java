import java.util.Scanner;

public class Main {
    public static int findLongestDistinctSubstring(int N, int D, String S) {
        int longest = -1;

        for(int i=0;i<N;i++){
            boolean[] vis = new boolean[26];

            for(int j=i;j<N;j++){
                int currIndx = S.charAt(j)-'a';

                if(vis[currIndx]) break;

                vis[currIndx] = true;

                if(Math.abs(S.charAt(i) - S.charAt(j)) == D){
                    longest = Math.max(longest,j-i+1);
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int D = scanner.nextInt();
        String S = scanner.next();
        int result = findLongestDistinctSubstring(N, D, S);
        System.out.println(result);
    }
}