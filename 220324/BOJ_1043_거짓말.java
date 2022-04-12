import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1043_거짓말 {
    static int N, M;
    static int[] parent;
    static boolean[] knowTruth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 사람수 N 파티수 M
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = MakeSet(N);

        // 진실을 아는 사람
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        if (n > 0) {
            knowTruth = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                knowTruth[i] = true;
            }
        }
        else {  // 진실을 아는 사람이 없으면 파티수가 최대
            System.out.println(M);
            System.exit(0);
            System.exit(0);
        }


        // union
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            if (cnt < 2) continue;
            for (int j = 0; j < cnt; j++) {
//                union();
            }
        }
        int[] ints = new int[2];
        // 파티 갈 수 있나? find

        // 갈 수 있는 파티 구하기

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
