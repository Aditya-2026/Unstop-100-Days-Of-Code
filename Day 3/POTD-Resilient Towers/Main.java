import java.util.*;

public class Main {
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public static int calculateRemainingTowers(int N, int K, int M, int[] heights) {
        Stack<Integer> st = new Stack<>();
        for(int ht : heights){
            int curr = ht;
            while(!st.isEmpty()){
                int last = st.peek();
                int gcd = gcd(ht,last);

                if(gcd>K){
                    if(M>0){
                        M--;
                        break;
                    }else{
                        curr = curr + last;
                        st.pop();
                    }
                }else{
                    break;
                }
            }

            st.push(curr);
        }

        return st.size();
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int M = scanner.nextInt();

        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = scanner.nextInt();
        }

        int result = calculateRemainingTowers(N, K, M, heights);

        System.out.println(result);
    }
}