import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int ans = 0;
        int[] sensors = new int[N];
        int[] lens = new int[N - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensors);

        // 간격 저장
        for (int i = 0; i < N - 1; i++) {
            lens[i] = sensors[i + 1] - sensors[i];
        }
        Arrays.sort(lens);

        // N-1 개의 간격 중에 가장 간격이 적은 것을 더한다
        // (N - 1) - (K - 1) = N - K
        for (int i = 0; i < N - K; i++) {
            ans += lens[i];
        }
        System.out.println(ans);
    }
}
