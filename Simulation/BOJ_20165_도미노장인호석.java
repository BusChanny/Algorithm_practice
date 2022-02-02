import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 *
 */
public class BOJ_20165_도미노장인호석 {
                      //E  W  S  N
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M, R, cnt;
    static int[][] map;
    static boolean[][] visited; // true면 쓰러짐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            // 공격
            st = new StringTokenizer(br.readLine());
            attack(Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()) - 1,
                    "EWSN".indexOf(st.nextToken()));
            // 수비
            st = new StringTokenizer(br.readLine());
            defense(Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()) - 1);
        }

        System.out.println(cnt);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) System.out.print("F" + " ");
                else System.out.print("S" + " ");
            }
            System.out.println();
        }

    }

    private static void defense(int x, int y) {
        if (visited[x][y]) visited[x][y] = false;
    }

    private static void attack(int x, int y, int d) {
        // 이미 쓰러진 위치면 돌아가기
        if (visited[x][y]) return;
        else {
            // 현재 위치 쓰러짐
            visited[x][y] = true;

            // 길이
            int len = map[x][y] - 1;

            // 점수
            cnt++;

            while (len > 0){
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 범위 체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) return;

                // 쓰러져 있다면 다음 위치로
                if (visited[nx][ny]) {
                    len--;
                    x = nx;
                    y = ny;
                    continue;
                }

                len--;
                cnt++;
                visited[nx][ny] = true;
                x = nx;
                y = ny;

                len = map[nx][ny] - 1 > len ? map[nx][ny] - 1 : len;
            }
        }
    }
}
