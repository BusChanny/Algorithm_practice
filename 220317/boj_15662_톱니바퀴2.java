import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15662_톱니바퀴2 {
    static int T, ans, K;
    static int[][] gear;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        gear = new int[T + 1][8];
        for (int i = 1; i <= T; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = str.charAt(j) - '0';
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            visited = new boolean[T + 1];
            rotate(N, D);
        }

        for (int i = 1; i <= T; i++) {
            if (gear[i][0] == 1) ans++;
        }

        System.out.println(ans);

    }

    private static void rotate(int n, int d) {

        visited[n] = true;
        // 방향에 따라 배열 이동
        if (d == 1) {
            int temp = gear[n][7];
            for (int i = 7; i >= 1; i--) {
                gear[n][i] = gear[n][i-1];
            }
            gear[n][0] = temp;
        }else{
            int temp = gear[n][0];
            for (int i = 0; i < 7; i++) {
                gear[n][i] = gear[n][i+1];
            }
            gear[n][7] = temp;
        }
        // 왼쪽 톱니 범위체크, 방문체크, 다른극 회전
        if (n - 1 >= 1 && gear[n-1][2] != gear[n][6+d] && !visited[n-1]){
            rotate(n-1, -d);
        }

        // 오른쪽 톱니 범위체크, 방문체크, 다른극 회전
        // 범위체크를 제일 먼저 해야한다.
        if (n + 1 <= T && gear[n+1][6] != gear[n][2+d] && !visited[n+1]){
            rotate(n+1, -d);
        }
    }
}
