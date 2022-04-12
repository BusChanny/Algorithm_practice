import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 민식이는 다음과 같은 폴리오미노 2개를 무한개만큼 가지고 있다. AAAA와 BB
 *
 * 이제 '.'와 'X'로 이루어진 보드판이 주어졌을 때, 민식이는 겹침없이 'X'를 모두 폴리오미노로 덮으려고 한다.
 * 이때, '.'는 폴리오미노로 덮으면 안 된다.
 *
 * 폴리오미노로 모두 덮은 보드판을 출력하는 프로그램을 작성하시오.
 *
 */
public class BOJ_1343_폴리오미노 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();

        int cnt = 0;
        for (int i = 0; i < board.length(); i++) {
            if (board.charAt(i) == 'X') {
                cnt++;
            }else {
                cnt = 0;
            }


        }
    }
}
