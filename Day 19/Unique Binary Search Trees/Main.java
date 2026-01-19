import java.util.Scanner;

public class Main {
    public static int numTrees(int n) {
        int[] catalanNumber = new int[n+1];
        catalanNumber[0] = 1;
        catalanNumber[1] = 1;

        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                int left = catalanNumber[j];
                int right = catalanNumber[i-j-1];

                catalanNumber[i] += left*right;
            }
        }
        return catalanNumber[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number_of_nodes = scanner.nextInt();
        
        System.out.println(numTrees(number_of_nodes));
        scanner.close();
    }
}
