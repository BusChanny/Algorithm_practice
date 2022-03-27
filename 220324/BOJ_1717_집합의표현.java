import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717_집합의표현 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] parent = MakeSet(N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (command.equals("0")){
                union(parent, a, b);
            }else{
                if (find(parent, a) != find(parent, b)) {
                    System.out.println("NO");
                }else {
                    System.out.println("YES");
                }
            }
        }


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
