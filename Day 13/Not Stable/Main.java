import java.util.*;

public class Main {
    public static String[] userLogic(int n, int[] arr) {
        Arrays.sort(arr);

        boolean possible = true;
        int sum = 0;

        for(int i=n-1;i>=0;i--){
           sum += arr[i];
           if(sum==0){
            possible = false;
            break;
           }
        }

        if(possible){
            String[] result = new String[n+1];
            result[0] = "POSSIBLE";
            for(int i=1;i<n+1;i++){
                result[i] = String.valueOf(arr[n-i]);
            }
            return result;
        }

        possible = true;
        sum = 0;

        for(int i=0;i<n;i++){
            sum += arr[i];
            if(sum==0){
                possible = false;
                break;
            }
        }

        if(possible){
            String[] result = new String[n+1];
            result[0] = "POSSIBLE";
            for(int i=1;i<n+1;i++){
                result[i] = String.valueOf(arr[i-1]);
            }
            return result;
        }

        return new String[]{"IMPOSSIBLE"};

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        
        String[] result = userLogic(n, arr);
        
        if (result[0].equals("IMPOSSIBLE")) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println("POSSIBLE");
            for (int i = 1; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}