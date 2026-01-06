import java.util.Scanner;

public class Main {
    public static long compareBits(String a, String b) {
        int n = a.length();
        int[] arr = new int[n];
        int i = 0;
        long count = 0;
        for(char ch : a.toCharArray()){
            arr[i++] = Character.getNumericValue(ch);
        }

        for(int j=0;j<=b.length()-n;j++){
            int s = j;
            int e = j+n;
            i=0;
            while(s<e){
                int num = Character.getNumericValue(b.charAt(s));
                if((num ^ arr[i]) == 1){
                    count++;
                }
                i++;s++;
            } 
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        System.out.println(compareBits(a, b));
    }
}