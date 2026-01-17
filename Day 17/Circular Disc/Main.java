import java.util.*;

public class Main {
    public static int minTimeToType(String word) {
        char[] arr = word.toCharArray();
        Arrays.sort(arr);

        int seconds = 0;
        int prevPos = 0;
        for(int i=0;i<arr.length;i++){
            int currPos = arr[i] - 'a';

            int antiClockWise = currPos-prevPos;

            int dist = Math.min(antiClockWise,(26 - antiClockWise));

            seconds += dist;
            prevPos = currPos;
        }
        seconds += word.length();
        return seconds;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int result = minTimeToType(word);
        System.out.println(result);
        scanner.close();
    }
}