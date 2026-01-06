import java.util.*;

class Main {
    public static void nthRow(int n){
        long curr = 1;
        System.out.print(curr + " ");
        for(int i=1;i<=n;i++){
            curr = curr * (n-i + 1)/i;
            System.out.print(curr + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nthRow(n);
    }
}