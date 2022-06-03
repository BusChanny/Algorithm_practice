import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N * M 체스판에 4가지로만 움직일 수 있다.
// 이동 횟수가 4번보다 적지 않으면, 이동 방법을 모두 한번씩 사용해야 한다.
// 4 방향 모두 움직이지 못하면 최대 4
// 2칸 위로, 1칸 오른쪽
// 1칸 위로, 2칸 오른쪽
// 1칸 아래로, 2칸 오른쪽
// 2칸 아래로, 1칸 오른쪽
// N과 M은 2,000,000,000보다 작거나 같은 자연수
public class BOJ_1783 {
    static int N, M, ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (N == 1) System.out.println(1);
        else if(N == 2) System.out.println(Math.min((M+1)/2 , 4));
        else if(N >= 3){
            if (M < 7) System.out.println(Math.min(M, 4));
            else System.out.println(M - 2);
        }
    }


}
