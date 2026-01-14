import java.util.Scanner;

class Main {
    public static int find_largest_pack(int N) {
        int num = N;
        while((num&(num-1)) != 0){
            num--;
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int result = find_largest_pack(N);
        System.out.println(result);
        scanner.close();
    }
}