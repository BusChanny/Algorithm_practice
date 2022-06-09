import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 씨앗 3개
public class BOJ_14620_꽃길 {
    static int N, ans = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");

        N = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(0, 0);

        System.out.println(ans);
    }

    private static void dfs(int depth, int sum) {
        if (depth == 3){
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 범위 체크
                if (isPossible(i ,j)){
                    // 상하좌우 가격 합계 계산
                    int temp = calc_sum(i, j);
                    init(i, j, true);
                    dfs(depth + 1, sum + temp);
                    init(i, j, false);
                }
            }
        }
    }

    private static void init(int x, int y, boolean flag) {
        if (flag){
            visited[x][y] = true;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                visited[nx][ny] = true;
            }
        }else {
            visited[x][y] = false;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                visited[nx][ny] = false;
            }
        }
    }

    private static int calc_sum(int x, int y) {
        int sum = map[x][y];

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            sum += map[nx][ny];
        }
        return sum;
    }

    private static boolean isPossible(int x, int y) {
        if (visited[x][y]) return false;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 1 || ny < 1 || nx > N || ny > N) return false;
            if (visited[nx][ny]) return false;
        }
        return true;

    }


}
