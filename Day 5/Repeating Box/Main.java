import java.util.*;

class Main {
    public static int solve(int N,int[] labels){
        Set<Integer> set = new HashSet<>();

        for(int box : labels){
            if(set.contains(box)){
                return box;
            }
            set.add(box);
        }
        return labels[0];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] labels = new int[N];

        for(int i=0;i<N;i++){
            labels[i] = sc.nextInt();
        }
        System.out.print(solve(N,labels));
    }
}