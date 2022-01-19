import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class BOJ_9342_염색체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String pattern = "(A|B|C|D|E|F)?A+F+C+(A|B|C|D|E|F)?$";
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            boolean dna_ck = Pattern.matches(pattern, str);

            if (dna_ck) System.out.println("Infected!");
            else System.out.println("Good");
        }
    }
}
