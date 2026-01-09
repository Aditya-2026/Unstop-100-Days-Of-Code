import java.util.*;

class Main {
    public static void findIndices(int n,int k,int[] A){
        int numLessThanK = 0;
        int count = 0;

        for(int i=0;i<n;i++){
            if(A[i]<k){
                numLessThanK++;
            }else if(A[i]==k){
                count++;
            }
        }

        System.out.println(count);
        while(count>0){
            System.out.print(numLessThanK + " ");
            count--;
            numLessThanK++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];

        for(int i=0;i<n;i++){
            A[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        findIndices(n,k,A);
    }
}