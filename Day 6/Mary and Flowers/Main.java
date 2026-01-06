import java.util.*;

public class Main {
    public static void find_flower_indices(int n, int t, int[] arr, int[] result) {
        int i=0;
        int j=n-1;
        while(i<j){
            int sum = arr[i]+arr[j];
            if(sum == t){
                result[0] = i;
                result[1] = j;
                return;
            }else if(sum<t){
                i++;
            }else{
                j--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] result = new int[2];
        find_flower_indices(n, t, arr, result);
        System.out.println(result[0] + " " + result[1]);
    }
}