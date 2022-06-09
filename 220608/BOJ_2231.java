import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 분해합
 *
 */
public class BOJ_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = 0;

        for (int i = 1; i <= N; i++) {
            int n = i;
            int temp = 0;

            while (n != 0) {
                temp += n % 10;
                n /= 10;
            }

            if (temp + i == N){
                M = i;
                break;
            }
        }
        System.out.println(M);
    }


}
