import java.util.*;

public class Main {
    public static int userLogic(int n, int[] arr) {
        final int MOD = 1000000007;
        
        List<Integer> list = new ArrayList<>();
        for (int x : arr) {
            list.add(x);
        }
        
        Collections.sort(list);

        long measurement = 0;
        for(int i=0;i<n;i++){
            measurement += i + list.lastIndexOf(arr[i]);
        }

        return (int)(measurement % MOD);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int measurement = userLogic(n, arr);
        System.out.println(measurement);
        scanner.close();
    }
}