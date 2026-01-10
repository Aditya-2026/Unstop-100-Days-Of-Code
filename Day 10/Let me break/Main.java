import java.util.*;

public class Main {
    public static boolean check_if_can_break(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        boolean s1breaks = true;
        boolean s2breaks = true;

        for(int i=0;i<s1.length();i++){
            if(arr1[i]<arr2[i]) s1breaks = false;
            if(arr1[i]>arr2[i]) s2breaks = false;
        }
        
        return (s1breaks || s2breaks) ? true : false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine(); 
        String s2 = scanner.nextLine(); 
        
        boolean result = check_if_can_break(s1, s2);
        if (result) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}