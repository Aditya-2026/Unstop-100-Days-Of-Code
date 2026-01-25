import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Main {
    public static long maxPossibleSum(int n,int k,int[] arr){
        long sum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : arr){
            sum += num;
            pq.offer(num);
        }

        while(k>0){
            int min= pq.poll();
            if(min >= 0){
                if((k & 1) == 1) sum -= 2L*min;
                break;
            }
            min = -min;
            sum += 2L * min;
            pq.offer(min);
            k--;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(maxPossibleSum(n,k,arr));
        sc.close();
    }
}