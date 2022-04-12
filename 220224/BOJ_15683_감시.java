import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 빈칸 0, 벽 6, CCTV 1 ~ 5
 * 회전시 90도 방향, 가로 또는 세로로 감시
 * CCTV 끼리는 통과 가능
 * CCTV 최대 개수 8개
 */
public class BOJ_15683_감시 {
    static int N, M;
    static int[][] map;
    static int[][] copy;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] dist = {4,2,4,4,1};
    static int[] num;
    static ArrayList<int[]> position = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && map[i][j] < 6){
                    position.add(new int[]{i, j});
                }
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        num = new int[position.size()];
        dfs(0);
    }

    private static void dfs(int cnt) {
        if (cnt == position.size()){
            copy = new int[N][M];
            for (int i = 0; i < N; i++) {   // 배열 복사
                System.arraycopy(map[i], 0, copy[i], 0, map[i].length);
            }

            for (int i = 0; i < position.size(); i++) {

            }

        }

       for (int j = 0; j < position.size(); j++) {
            num[cnt] = j;
            dfs(cnt + 1);
        }


    }
}
