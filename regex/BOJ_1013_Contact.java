import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class BOJ_1013_Contact {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 전파 패턴 : (100+1+ | 01)+
        String pattern = "(100+1+|01)+";
        for (int i = 0; i < N; i++) {
            if (Pattern.matches(pattern, br.readLine())) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
