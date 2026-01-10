import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strings = new String[n];
        for(int i=0;i<n;i++){
            String s = sc.next();
            strings[i] = s;
        }
        int k = sc.nextInt();
        HashMap<String,Integer> map = new HashMap<>();

        for(String x: strings){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int count = 0;
        for(String x: strings){
            if(map.get(x) == 1){
                count++;
            }
            if(count == k){
                System.out.print(x);
                return;
            }
        }
        System.out.print(-1);

    }
}