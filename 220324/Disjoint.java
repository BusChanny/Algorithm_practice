import java.util.Arrays;

public class Disjoint {
    public static void main(String[] args) {
        int[] parent = MakeSet(5);

        System.out.println(Arrays.toString(parent));
    }

    private static int[] MakeSet(int size) {
        int[] arr = new int[size + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }

    private static int find(int[] parent, int x){
        if (parent[x] == x) {
            return x;
        }else {
            return parent[x] = find(parent, parent[x]);
        }

    }

    private static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }
}
