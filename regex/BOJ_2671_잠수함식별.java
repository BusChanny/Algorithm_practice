import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class BOJ_2671_잠수함식별 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 엔진소리 패턴 : (100~1~|01)~
        String pattern = "(100+1+|01)+";
        String str = br.readLine();

        if (Pattern.matches(pattern, str)) System.out.println("SUBMARINE");
        else System.out.println("NOISE");
    }
}
