import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_14465_소가길을건너간이유5 {
    static HashMap<Integer, Integer> answer = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = sliding_window(arr, X);
        if (ans == 0) System.out.println("SAD");
        else{
            System.out.println(ans);
            System.out.println(answer.get(ans));
        }


    }

    static int sliding_window(int[] arr, int k) {
        int windowSum = 0, windowStart = 0, maxSum = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            if (windowEnd - windowStart >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                Integer cnt = answer.get(maxSum);
                if (cnt == null) answer.put(maxSum, 1);
                else answer.put(maxSum, cnt + 1);
                windowSum -= arr[windowStart++];
            }
        }
        return maxSum;
    }
}
