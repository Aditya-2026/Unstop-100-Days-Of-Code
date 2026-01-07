import java.util.*;

class Main {
    public static int solve(int N,int[] arr){
        Arrays.sort(arr);
        int sum = 0;
        for(int i=0;i<N;i+=2){
            sum += arr[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(solve(N,arr));
    }
}