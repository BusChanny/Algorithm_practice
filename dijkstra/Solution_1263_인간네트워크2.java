import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1263_인간네트워크2 {
    static int N;
    static int[][] map;
    static int[] distance;
    static boolean[] visited;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            distance = new int[N];
            visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            Arrays.fill(distance, INF);
            distance[0] = 0;
            int min = 0;
            for (int i = 0; i < N; ++i) {
                min = INF;
                for (int j = 0; j < N; ++j) {

                }
            }

        }

    }
}
