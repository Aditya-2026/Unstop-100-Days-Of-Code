import java.util.*;

public class Main {
    public static List<Integer> modifyArray(int n, List<Integer> arr) {
        int max = arr.get(0);
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            int curr = arr.get(i);
            max = Math.max(max,curr);
            ans.add(max+curr);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        List<Integer> modifiedArr = modifyArray(n, arr);
        for (int num : modifiedArr) {
            System.out.print(num + " ");
        }
    }
}