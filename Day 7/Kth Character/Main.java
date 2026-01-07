import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        char[] arr = new char[n];
        arr= sc.next().toCharArray();
        
        System.out.print(arr[n-k]);
    }
}