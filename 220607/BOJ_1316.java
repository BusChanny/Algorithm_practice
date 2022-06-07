import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int ans = 0;

        outer :for (int i = 0; i < T; i++) {
            String str = br.readLine();
            boolean[] check = new boolean[26];
            // 첫 알파벳 존재 여부 체크
            char prevAlpabet = str.charAt(0);
            check[prevAlpabet - 'a'] = true;
            for (int j = 1; j < str.length(); j++) {
                char curAlpabet = str.charAt(j);

                // 이전 알파벳과 중복이면 넘어가기
                if (curAlpabet == prevAlpabet){
                    continue;
                // 처음 들어온 알파벳일 때
                }else if (!check[curAlpabet -'a']){
                    check[curAlpabet - 'a'] = true;
                // 이전 알파벳과 같지 않고 중복일 때
                }else if(curAlpabet != prevAlpabet && check[curAlpabet - 'a']){
                    continue outer;
                }
                prevAlpabet = curAlpabet;
            }
            // 정답 올리기
            ans++;
        }
        System.out.println(ans);
    }
}
