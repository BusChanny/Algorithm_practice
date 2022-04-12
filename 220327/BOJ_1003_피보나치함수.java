import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003_피보나치함수 {
    static int oneCnt, zeroCnt;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            oneCnt = 0; zeroCnt = 0;
            int N = Integer.parseInt(br.readLine());
            dp = new int[N + 1];

            fibonacci(N);
            System.out.println(zeroCnt + " " + oneCnt);
        }
    }

    private static int fibonacci(int n) {
        if (n == 0) {
            zeroCnt++;
            return 0;
        } else if (n == 1) {
            oneCnt++;
            return 1;
        }else {
            return fibonacci(n-1) + fibonacci(n - 2);
        }
    }
}
