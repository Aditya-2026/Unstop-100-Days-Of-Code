import java.util.*;

public class Main {
    public static boolean isPeak(int indx,int[] arr){
        return (indx > 0) && (indx < arr.length-1) 
                && (arr[indx]>arr[indx-1]) && (arr[indx]>arr[indx+1]);
    }
    public static void minimumEnergyPeaks(int n, int[] arr) {
        int peaks = 0;

        for(int i=0;i<n;i++){
            if(isPeak(i,arr)){
                peaks++;
            }
        }

        if (peaks == 0) {
            System.out.print(0);
            return;
        }

        int minPeaks = peaks;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){

                Set<Integer> affected = new HashSet<>();
                for (int d = -1; d <= 1; d++) {
                    if (i + d >= 1 && i + d < n - 1) affected.add(i + d);
                    if (j + d >= 1 && j + d < n - 1) affected.add(j + d);
                }

                int before = 0;
                for (int idx : affected) {
                    if (isPeak(idx,arr)) before++;
                }

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                int after = 0;
                for (int idx : affected) {
                    if (isPeak(idx, arr)) after++;
                }

                int temp1 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp1;

                minPeaks = Math.min(minPeaks,peaks-before+after);
            }
        }

        System.out.print(minPeaks);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        minimumEnergyPeaks(n, arr);
        scanner.close();
    }
}
