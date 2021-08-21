import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5_1018_체스판다시칠하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        int min = Integer.MAX_VALUE;
        // 정사각형 판 만들기
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }


        for (int i = 0; i < N - 8 + 1; i++) {
            for (int j = 0; j < M - 8 + 1; j++) {
                //8 * 8 체스판에 값넣기
                char first = map[i][j];
                int cnt = 0;
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        if(map[i + x][j + y] != first) {    // 처음값과 같지 않으면 색이 틀렸으므로 카운트 증가
                            cnt++;
                        }
                        // 다음 값을 판별하기 위해 first 변경
                        first = first == 'W' ? 'B' : 'W';
                    }
                    first = first == 'W' ? 'B' : 'W';
                }
                // 색이 반대로 시작할 수 있기 떄문에 반대의 결과값 최솟값 비교
                cnt = Math.min(cnt, 64 - cnt);
                // 최솟값 구하기
                min = Math.min(min, cnt);
            }
        }

        System.out.println(min);
    }
}
