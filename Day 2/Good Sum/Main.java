import java.util.*;

public class Main {
    public static int goodSum(int N, int[] A) {
        if(N==0){
            return 0;
        }
        if(A[0]<0){
            A[0] = Math.abs(A[0]);
        }
        for(int i=1;i<N;i++){
            if(A[i]<0){
                int sum = 0;
                int j=i;
                int absValue = Math.abs(A[i]);
                do{
                    j--;
                    sum += A[j];
                    A[j] = 0;
                }while(j>0 && sum<absValue);
                A[i] = Math.abs(A[i]);
            }
        }
        int ans = 0;
        for(int num : A){
            ans += num;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();  
        }
        
        int result = goodSum(N, A);
        System.out.println(result);
    }
}