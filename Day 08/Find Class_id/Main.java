import java.util.*;

public class Main {

    public static int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length-1;

        while(left<right){
            int mid = left + (right-left)/2;

            if(A[mid]<A[mid+1]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        
        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(peakIndexInMountainArray(arr));
    }

}
