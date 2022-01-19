import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/***
 * 1. 7명의 여학생들로 구성
 * 2. 7명의 자리는 가로나 세로로 반드시 인접
 * 3. 반드시 이다솜파일 필요 없음
 * 4. 이다솜파가 적어도 4명 이상 포함
 * S : 이다솜파 Y : 임도연파
 *
 * BFS?로 4명 이상을 체크하며
 * 임도연파가 3명보다 크면 continue
 */
public class BOJ_1941_G3_소문난칠공주 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;
    static boolean[] visited;
    static int[] selected;
    static int answer, cntS, cntY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[5][5];
        selected = new int[7];

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        solve(0, 0);
    }

    private static void solve(int cnt, int start) {
        if (cnt == 7){
            cntY = 0;
            bfs(0);
            return;
        }
        for (int i = start; i < 25; i++) {
            selected[cnt] = i;
            solve(cnt + 1, i + 1);
        }
    }

    private static void bfs(int cnt) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {selected[cnt] / 5 , selected[cnt] % 5});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            for (int d = 0; d < 4; d++) {
                if (cnt == 6) {
                    answer++;
                    break;
                }
                int nx = curX + dx[d];
                int ny = curY + dy[d];
                // 인접해있으면
                if (map[nx][ny] == map[selected[cnt + 1] / 5][selected[cnt + 1] % 5]) {
                    queue.offer(new int[] {nx, ny});
                }
            }
        }

    }


}
