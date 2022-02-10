import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1946_신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            // 지원자의 수
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            for (int n = 1; n <= N; n++) {
                st = new StringTokenizer(br.readLine());
                int docu = Integer.parseInt(st.nextToken());
                int interV = Integer.parseInt(st.nextToken());
                // 서류 순위로 정렬
                arr[docu] = interV;
            }
            // 서류 1등은 무조건 합격으로 시작
            int cnt = 1;

            // 합격시 갱신할 순위 (서류 1등의 면접 순위로 시작)
            int next = arr[1];

            for (int i = 2; i <= N; i++) {
                // 서류순위가 나보다 높은 사람이 면접 순위가 나보다 작으면 합격
                if (arr[i] < next){
                    cnt++;
                    next = arr[i];
                }
            }
            System.out.println(cnt);
        }
    }
}
