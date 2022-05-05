import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] jump = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                jump[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 경로의 개수는 2^63-1보다 작거나 같다.
        long[][] DP = new long[N][N];
        DP[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 종착점 도착 체크
                if (i == N - 1 && j == N - 1) continue;

                int right = j + jump[i][j];
                int down = i + jump[i][j];

                // 이동할 수 있다면 이전 경우의 수 더하기(메모이제이션)
                if (right <= N - 1) DP[i][right] += DP[i][j];
                if (down <= N - 1) DP[down][j] += DP[i][j];
            }
        }
        System.out.println(DP[N-1][N-1]);
    }
}
