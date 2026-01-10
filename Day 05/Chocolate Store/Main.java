import java.util.*;

public class Main {
    public static void processQueries(int q, List<String[]> queries) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<q;i++){
            String[] query = queries.get(i);
            if(query[0].equals("1")){
                map.put(query[1],map.getOrDefault(query[1],0)+Integer.parseInt(query[2]));
            }else{
                int need = Integer.parseInt(query[2]);
                int available = map.getOrDefault(query[1],0);
                if(available>=need){
                    map.put(query[1],available-need);
                    System.out.println(need);
                }else{
                    map.put(query[1],0);
                    System.out.println(available);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        scanner.nextLine(); 
        List<String[]> queries = new ArrayList<>();
        for (int i = 0; i < q; ++i) {
            String[] parts = scanner.nextLine().split(" ");
            queries.add(parts);
        }
        processQueries(q, queries);
    }
}