import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 두 생명체 A, B
 * A는 B를 먹는다
 * A는 자기보다 크기가 작은 먹이만 먹을 수 있다.
 *
 */
public class BOJ_7795_먹을것인가먹힐것인가 {
    static int A, B, N, M, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int[] arr_A = new int[N];
            int[] arr_B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr_A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arr_B[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr_A);
            Arrays.sort(arr_B);
            ans = 0;
            for (int i : arr_A) {
                for (int j : arr_B) {
                    if (i <= j) break;
                    else ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
