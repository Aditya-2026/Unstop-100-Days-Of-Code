import java.io.*;
import java.util.*;
import java.util.HashSet;

public class Main {
    public static int countConsistentCars(String components, int n, List<String> models) {
        HashSet<Character> set = new HashSet<>();
        for(char ch : components.toCharArray()){
            set.add(ch);
        }

        int count = 0;
        for(String s : models){
            for(int i=0;i<s.length();i++){
                if(!set.contains(s.charAt(i))){
                    break;
                }
                if(i==s.length()-1){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String components = reader.readLine();
    if (components == null || components.isEmpty()) return;
    components = components.trim();

    String nLine = reader.readLine();
    if (nLine == null || nLine.isEmpty()) return;
    int n = Integer.parseInt(nLine.trim());

    List<String> models = new ArrayList<>();
    String[] arr = reader.readLine().trim().split("\\s+");
    models.addAll(Arrays.asList(arr));

    System.out.println(countConsistentCars(components,n, models));
    }
}