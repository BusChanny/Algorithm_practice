import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] time = new int[101];

        int priceA = Integer.parseInt(st.nextToken());
        int priceB = Integer.parseInt(st.nextToken());
        int priceC = Integer.parseInt(st.nextToken());
        int ans = 0;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            for (int j = from; j < to; j++) {
                time[j]++;
            }
        }

        for (int i = 0; i < time.length; i++) {
            if (time[i] == 1) {
                ans += priceA  * time[i];
            }else if (time[i] == 2){
                ans += priceB * time[i];
            }else if (time[i] == 3){
                ans += priceC * time[i];
            }else {
                continue;
            }
        }

        System.out.println(ans);

    }
}
