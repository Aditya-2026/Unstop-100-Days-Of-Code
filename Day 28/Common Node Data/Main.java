import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        for(int i=0;i<m;i++){
            b[i] = sc.nextInt();
        }

        int i = n - 1;
        int j = m - 1;
        int ans = -1;

        while(i>=0 && j>=0 && a[i] == b[j]){
            ans = a[i];
            i--;j--;
        }
        System.out.println(ans);
        sc.close();
    }
}