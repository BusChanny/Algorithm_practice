import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[2][N + 1];
            int[][] DP = new int[2][N + 1];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            DP[0][1] = sticker[0][1];
            DP[1][1] = sticker[1][1];

            for (int i = 2; i <= N; i++) {
                DP[0][i] = Math.max(DP[1][i-1], DP[1][i-2]) + sticker[0][i];
                DP[1][i] = Math.max(DP[0][i-1], DP[0][i-2]) + sticker[1][i];
            }

            System.out.println(Math.max(DP[0][N], DP[1][N]));
        }
    }
}
