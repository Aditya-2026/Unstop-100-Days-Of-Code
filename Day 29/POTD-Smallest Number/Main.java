import java.util.*;

public class Main {
    public static int findSmallestUnexpressiblePower(int[] arr) {
        Arrays.sort(arr);

        int ans = 0;
        int i = 0;
        int n = arr.length;

        while(i<n){
            int num = arr[i];
            int count = 1;

            while(i+1<n && arr[i+1] == arr[i]){
                count++;
                i++;
            }

            if(num > ans+1){
                break;
            }

            ans += num * count;
            i++;
        }

        return ans+1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int result = findSmallestUnexpressiblePower(arr);
        System.out.println(result);
        scanner.close();
    }
}