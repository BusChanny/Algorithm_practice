import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  주문의 수 N(1 ≤ N ≤ 100)
 *  치즈버거 개수 M(1 ≤ M ≤ 300)
 *  남은 감자튀김 개수 K(1 ≤ K ≤ 300)
 */
public class BOJ_17208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] burger = new int[301];
        int[] potato = new int[301];
        int[][][] DP = new int[101][301][301];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            burger[i] = Integer.parseInt(st.nextToken());
            potato[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {  // order
            for (int j = 1; j <= M; j++) {  // burger
                for (int k = 1; k <= K; k++) {  // potato
                    if (j >= burger[i] && k >= potato[i]) {
                        DP[i][j][k] = Math.max(DP[i - 1][j][k], DP[i - 1][j - burger[i]][k - potato[i]] + 1);
                    }else
                        DP[i][j][k] = DP[i - 1][j][k];
                }
            }
        }
        System.out.println(DP[N][M][K]);
    }
}
