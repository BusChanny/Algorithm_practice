import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_10282_해킹2 {
    static class Com implements Comparable<Com> {
        int dest, time;

        public Com(int dest, int time) {
            this.dest = dest;
            this.time = time;
        }

        @Override
        public int compareTo(Com o) {
            return this.time - o.time;
        }
    }
    static int n, d, c, a, b, s, distance[], time, cnt;
    static boolean[] visited;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            time = 0;
            cnt = 0;
            map = new int[n + 1][n + 1];

            distance = new int[n + 1];
            visited = new boolean[n + 1];

            Arrays.fill(distance, Integer.MAX_VALUE);


            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());
                map[a][b] = map[b][a] = s;
            }

            dijkstra(c);

            System.out.println(Arrays.toString(distance));
        }
    }

    private static void dijkstra(int start) {
        visited[c] = true;
        distance[c] = 0;

        for (int i = 1; i < n+1; i++) {
            if (!visited[i] && map[start][i] != 0){
                distance[i] = map[start][i];
            }
        }

        for (int i = 0; i < n - 1; i++) {
            int min = Integer.MAX_VALUE;
            int min_index = -1;
            for (int j = 1; j < n + 1; j++) {
                if (!visited[j] && distance[j] != Integer.MAX_VALUE) {
                    if (distance[j] < min) {
                        min = distance[j];
                        min_index = j;
                    }
                }
            }
            visited[min_index] = true;
            for (int j = 1; j < n + 1; j++) {
                if (distance[j] > distance[min_index] + map[min_index][j]) {
                    distance[j] = distance[min_index] + map[min_index][j];
                }
            }
        }
    }
}



