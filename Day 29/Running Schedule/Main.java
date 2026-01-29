import java.util.*;

public class Main {
    static int findSnoopDayIndex(int n, int[] arr) {
        int totalSum = 0;
        for(int num : arr){
            totalSum += num;
        }

        int curr = 0;
        for(int i=0;i<n;i++){
            curr += arr[i];
            if(curr*2 >= totalSum){
                return i+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int result = findSnoopDayIndex(n, arr);
        System.out.println(result);
        scanner.close();
    }
}