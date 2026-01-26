import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void userLogic(int capacity, List<String> operations) {
        List<Integer> stack = new ArrayList<>();
        List<String> output = new ArrayList<>();

        output.add("null");

        for (String op : operations) {
            String[] parts = op.split(" ");

            if (parts[0].equals("push")) {
                int x = Integer.parseInt(parts[1]);
                if (stack.size() < capacity) {
                    stack.add(x);
                }
                output.add("null");

            } else if (parts[0].equals("pop")) {
                if (stack.isEmpty()) {
                    output.add("-1");
                } else {
                    int val = stack.remove(stack.size() - 1);
                    output.add(String.valueOf(val));
                }

            } else if (parts[0].equals("increment")) {
                int k = Integer.parseInt(parts[1]);
                int inc = Integer.parseInt(parts[2]);

                int limit = Math.min(k, stack.size());
                for (int i = 0; i < limit; i++) {
                    stack.set(i, stack.get(i) + inc);
                }
                output.add("null");
            }
        }

        for (int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i));
            if (i < output.size() - 1) System.out.print(" ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int capacity = Integer.parseInt(reader.readLine());
        int numOperations = Integer.parseInt(reader.readLine());
        List<String> operations = new ArrayList<>();
        for (int i = 0; i < numOperations; i++) {
            operations.add(reader.readLine());
        }

        userLogic(capacity, operations);
        reader.close();
    }
}
