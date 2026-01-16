import java.util.*;

public class Main {
    public static int heightChecker(int[] heights) {
        int n = heights.length;
        int[] expected = Arrays.copyOf(heights,n);

        Arrays.sort(expected);

        int count = 0;

        for(int i=0;i<n;i++){
            if(heights[i] != expected[i]){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int result = heightChecker(arr);
        System.out.println(result);
        sc.close();
    }
}