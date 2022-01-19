import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class BOJ_9996_한국이그리울땐서버에접속하 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        String pattern = br.readLine().replace("*", "[a-z]*");
        // * : 앞 문자가 없을 수도 무한정 많을 수도 있음
        // [a - z] : 문자의 집합이나 범위를 나타내며 두 문자 사이는 - 기호로 범위를 나타낸다.
        // [] 내에서 ^ 가 선행하여 존재하면 not을 나타낸다.
        for (int i = 0; i < T; i++) {
            String temp = br.readLine();
            boolean str_ck = Pattern.matches(pattern, temp);

            if (str_ck) System.out.println("DA");
            else System.out.println("NE");
        }
    }
}
