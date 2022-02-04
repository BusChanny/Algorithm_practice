package bfs.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2638_치즈 {
    static class Pos{
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        Pos temp = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) temp = new Pos(i, j);
            }
        }

        int time = 0;
        boolean flag = true;
        while (flag){
            visited = new boolean[N][M];
            BFS(temp.x, temp.y);

            flag = false;
            outer: for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0){
                        flag = true;
                        temp.x = i;
                        temp.y = j;
                        break outer;
                    }
                }
            }
            time++;
        }
        System.out.println(time);
    }

    private static void BFS(int x, int y) {
        Queue<Pos> q = new LinkedList<>();

        q.offer(new Pos(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Pos temp = q.poll();
            int cnt = 0;
            for (int d = 0; d < 4; d++) {
                int nx = temp.x + dx[d];
                int ny = temp.y + dy[d];
                // 방문 체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (visited[nx][ny]) continue;

                if (map[nx][ny] == 0 && !visited[nx][ny]) cnt++;
                else {
                    visited[nx][ny] = true;
                    q.offer(new Pos(nx, ny));
                }
            }
            // 2변 이상이 닿아있으면 지워짐
            if (cnt >= 2) map[temp.x][temp.y] = 0;
        }
    }
}
