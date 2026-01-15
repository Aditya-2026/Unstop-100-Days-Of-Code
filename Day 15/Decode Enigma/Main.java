import java.util.Scanner;

public class Main {
    public static void interpret(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'S'){
                sb.append("send");
            }else if(s.charAt(i) == '['){
                if(s.charAt(i+1) == ']'){
                    sb.append("the");
                    i++;
                }else{
                    sb.append("ships");
                    i+=4;
                }
            }
            if(i != s.length()-1){
                sb.append(" ");
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        interpret(s);
        scanner.close();
    }
}