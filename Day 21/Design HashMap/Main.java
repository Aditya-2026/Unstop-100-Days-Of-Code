import java.util.*;

class Main {

    static class Node{
        int key;
        int val;
        Node next;

        Node(int key, int val){
            this.key = key;
            this.val = val;
            next = null;
        }
    }

    static class HashMap{
        private static final int size =  10007;
        private Node[] buckets;

        HashMap(){
            buckets = new Node[size];
        }

        private int hash(int key){
            return key % size; 
        }

        void insert(int key,int value){
            int indx = hash(key);
            Node curr = buckets[indx];

            while(curr != null){
                if(curr.key == key){
                    curr.val = value;
                    return;
                }
                curr = curr.next;
            }

            Node node = new Node(key,value);
            node.next = buckets[indx];
            buckets[indx] = node;
        }

        int get(int key){
            int indx = hash(key);
            Node curr = buckets[indx];

            while(curr != null){
                if(curr.key == key){
                    return curr.val;
                }
                curr = curr.next;
            }

            return -1;
        }

        void delete(int key){
            int indx = hash(key);
            Node prev = null;
            Node curr = buckets[indx];

            while(curr != null){
                if(curr.key == key){
                    if(prev == null){
                        buckets[indx] = curr.next;
                    }else{
                        prev.next = curr.next;
                    }
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
        }
    }

    public static List<Integer> processQueries(List<Tuple> queries) {
        List<Integer> result = new ArrayList<>();

        HashMap map = new HashMap();
        for(Tuple query : queries){
            if(query.type == 1){
                map.insert(query.key,query.value);
            }else if(query.type == 2){
                int val = map.get(query.key);
                result.add(val);
            }else{
                map.delete(query.key);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Tuple> queries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int queryType = scanner.nextInt();
            if (queryType == 1) {
                int key = scanner.nextInt();
                int value = scanner.nextInt();
                queries.add(new Tuple(1, key, value));
            } else if (queryType == 2) {
                int key = scanner.nextInt();
                queries.add(new Tuple(2, key, 0));
            } else if (queryType == 3) {
                int key = scanner.nextInt();
                queries.add(new Tuple(3, key, 0));
            }
        }
        List<Integer> results = processQueries(queries);
        for (int result : results) {
            System.out.println(result);
        }
        scanner.close();
    }

    static class Tuple {
        int type, key, value;
        Tuple(int type, int key, int value) {
            this.type = type;
            this.key = key;
            this.value = value;
        }
    }
}