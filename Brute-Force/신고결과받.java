import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 신고결과받 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        System.out.println(Arrays.toString(Solution(id_list, report, k)));
    }

    private static int[] Solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        StringTokenizer st;
        boolean[][] visited = new boolean[id_list.length][id_list.length];

        // 신고
        for(int i = 0; i < report.length; i++){
            st = new StringTokenizer(report[i]);
            visited[Arrays.asList(id_list).indexOf(st.nextToken())]
                    [Arrays.asList(id_list).indexOf(st.nextToken())] = true;
        }

        int[] temp = new int[id_list.length];
        // 신고 횟수 처리
        for (int i = 0; i < id_list.length; i++)
            for (int j = 0; j < id_list.length; j++)
                if (visited[j][i]) temp[i]++;


        // 메일 보낼 사람 처리
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] >= k) {
                for (int j = 0; j < id_list.length; j++)
                    if (visited[j][i]) answer[j]++;
            }
        }
        return answer;
    }
}
