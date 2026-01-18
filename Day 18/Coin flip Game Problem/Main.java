import java.util.*;

public class Main {
    public static int find(int m) {
        int H = m;
        char[] coins = new char[m];
        Arrays.fill(coins,'H');
        for(int i=2;i<=m;i++){
            for(int j=i-1;j<m;j+=i){
                if(coins[j] == 'H'){
                    coins[j] = 'T';
                    H--;
                }else{
                    coins[j] = 'H';
                    H++;
                }
            }
        }
        return H;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int count = find(m);
        System.out.println(count);
        scanner.close();
    }
}