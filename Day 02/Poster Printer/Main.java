import java.util.*;
class Main {
    static boolean isvalidSequence(String s){
    boolean b = false;
    boolean r = false;

    for(char c : s.toCharArray()){
        if(c == 'R'){
          r = true; 
        }else if(c == 'B'){
          b = true;
        }else if(c == 'W'){
          if(r ^ b){
            return false;
          }
          r = b = false;
        }
    }

    return !(r^b);
  }
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      sc.nextLine();
      String arr[] = new String [T];
      for(int i=0;i<T;i++){
        int N =sc.nextInt();
        sc.nextLine();
        arr[i] = sc.nextLine();
      }
      for(int i = 0;i<T;i++){
         if(isvalidSequence(arr[i])){
          System.out.println("YES");
        }else{
          System.out.println("NO");
        }
      }
      sc.close();
  }
}