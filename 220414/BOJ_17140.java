import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/***
 *
 */
public class BOJ_17140 {
    static class Num implements Comparable<Num>{
        int n;
        int len;

        public Num(int n, int len) {
            this.n = n;
            this.len = len;
        }


        @Override
        public int compareTo(Num o) {
           // 수의 등장 횟수가 커지는 순 -> 수가 커지는 순
            if (this.len == o.len){
                return this.n < o.n ? -1 : 1;
            }
            return this.len < o.len ? -1 : 1;
        }
    }
    static int r, c, k;
    static int[][] map;
    static int[] count;
    static int time = -1;
    static ArrayList<Num> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        map = new int[3][3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        while(true){
            time++;
            //100초 넘어가면 -1
            if (time > 100){
                time = -1;
                break;
            }
            // k 찾으면 종료
            if (r < map.length && c < map[0].length){
                if (map[r][c] == k) break;
            }

            int[][] temp = new int[101][101];

            int row = map.length;
            int col = map[0].length;
            if (row >= col){
                rOperation(row, col, temp);

            }
        }

    }

    private static void rOperation(int row, int col, int[][] temp) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            count = new int[101];
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) continue;
                count[map[i][j]]++;
            }
            list = new ArrayList<>();

            for (int j = 1; j < count.length; j++) {
                if (count[j] != 0){
                    list.add(new Num(j, count[j]));
                }
            }
            Collections.sort(list);

            int k = 0;
            for (int j = 0; j < list.size(); j++) {
                temp[i][k] = list.get(j).n;
                temp[i][k + 1] = list.get(j).len;
                k += 2;
            }
            if (max < list.size() * 2) max = list.size() * 2;
        }
    }
}
