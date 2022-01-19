import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 일마다 정해진 급여
 * 오차없이 일급 당일 따박
 * 정해진 인수 만큼만 일 시킨다
 * 한번 퇴직한자 다시 퇴직 x
 *
 * @input
 * 월세를 내기 전날 n (1 <= n <= 100,000)
 * 일 할 수 있는 날 m (0 <= m <= n)
 * 일급 Ti (0 < Ti ≤ 1,000,000) -> 값이 크므로 long형 사용하기
 * @output
 * 준수가 일해서 버는 최대 이익 출력
 */
public class BOJ_12847_꿀아르바이트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }

        long max = sum;
        for (int i = 0; i + m < n; i++) {
            sum -= arr[i];      // 첫 원소 빼고
            sum += arr[i + m];  // 추가될 원소 추가
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
