import java.util.*;

class Main {
    public static int[] userLogic(int[] fat, int[] protein, int[] vitamin) {
        Set<Integer> fatSet = new HashSet<>();
        Set<Integer> proteinSet = new HashSet<>();
        Set<Integer> vitaminSet = new HashSet<>();

        for (int x : fat) fatSet.add(x);
        for (int x : protein) proteinSet.add(x);
        for (int x : vitamin) vitaminSet.add(x);

        int[] ans = new int[3];

        for (int x : fat){
            if (!proteinSet.contains(x) && !vitaminSet.contains(x))
                ans[0]++;
        }

        for (int x : protein){
            if (!fatSet.contains(x) && !vitaminSet.contains(x))
                ans[1]++;
        }

        for (int x : vitamin){
            if (!fatSet.contains(x) && !proteinSet.contains(x))
                ans[2]++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fat = new int[n];
        int[] protein = new int[n];
        int[] vitamin = new int[n];
        for (int i = 0; i < n; i++) {
            fat[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            protein[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            vitamin[i] = sc.nextInt();
        }
        int[] result = userLogic(fat, protein, vitamin);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
        sc.close();
    }
}