package bfs.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_17471_게리멘더링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int[] popul = new int[N + 1];   // 구역별 인구수
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            popul[i] = Integer.parseInt(st.nextToken());
        }


    }
}
