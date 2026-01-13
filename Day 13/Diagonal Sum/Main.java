import java.util.*;

class Main {
    public static int diagonalSum(int n) {
        if(n%2 == 0){
            return 2*n;
        }else{
            return 2*n-1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(diagonalSum(n));
        scanner.close();
    }
}
