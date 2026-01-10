import java.util.*;

class Main {
    public static void majoritySubsequence(int[] votes,int n){
        int totSum = 0;
        for(int num : votes){
            totSum += num;
        }

        Arrays.sort(votes);
        List<Integer> result = new ArrayList<>();
        result.add(votes[n-1]);

        int currSum = votes[n-1];
        int i = n-2;
        while((i>=0) && (currSum <= totSum-currSum)){
            currSum += votes[i];
            result.add(votes[i]);
            i--;
        }
        
        for(int num : result){
            System.out.print(num+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] votes = new int[n];

        for(int i=0;i<n;i++){
            votes[i] = sc.nextInt();
        }

        majoritySubsequence(votes,n);
    }
}