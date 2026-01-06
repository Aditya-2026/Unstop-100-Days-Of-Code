import java.util.*;

class Main {
    public static boolean userLogic(String bob, String alice) {
        int i = bob.length()-1;
        int j = alice.length()-1;
        while(i>=0 && j>=0){
            if(bob.charAt(i)=='#'){
                int hash1 = 1;
                if(i>0){
                    i--;
                    while(i>0 && bob.charAt(i)=='#'){
                        hash1++;
                        i--;
                    }
                }
            }
            if(alice.charAt(j)=='#'){
                int hash2 =1;
                if(j>0){
                    j--;
                    while(j>0 && alice.charAt(j)=='#'){
                        hash2++;
                        j--;
                    }
                    
                }
            }
            if(bob.charAt(i) != alice.charAt(j)){
                return false;
            }
            i--;j--;
        }
        return i==j;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bob = sc.nextLine();
        String alice = sc.nextLine();
        boolean result = userLogic(bob, alice);
        System.out.println(result ? "YES" : "NO");
    }
}