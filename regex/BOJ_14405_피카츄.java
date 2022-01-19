import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class BOJ_14405_피카츄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String pattern = "(pi|ka|chu)+";

        if (Pattern.matches(pattern, str)) System.out.println("YES");
        else System.out.println("NO");
    }
}
