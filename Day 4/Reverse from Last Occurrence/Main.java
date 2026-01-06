import java.util.Scanner;

public class Main {
    public static String transformString(String s, char ch) {
        int lastOcc = -1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ch){
                lastOcc = i;
            }
        }
        if(lastOcc==-1){
            return s;
        }else{
            String s1 = s.substring(0,lastOcc+1);
            StringBuilder s2 = new StringBuilder(s.substring(lastOcc+1,s.length()));
            s2.reverse();
            return s1+s2.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] data = input.split(" ");
        String s = data[0];
        char ch = data[1].charAt(0);
        
        String result = transformString(s, ch);
        System.out.println(result);
    }
}