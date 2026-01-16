import java.util.*;

public class Main {
    public static int find_winner(int[] arr) {
        Map<Integer,Integer> freq = new HashMap<>();

        for(int num : arr){
            freq.put(num,freq.getOrDefault(num,0) + 1);
        }

        for(int num : arr){
            if(freq.get(num) == 1){
                return num;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int result = find_winner(arr);
        System.out.println(result);
        scanner.close();
    }
}