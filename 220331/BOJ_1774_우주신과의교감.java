import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1774_우주신과의교감 {
    static class Edge implements Comparable<Edge> {
        int start, end;
        double dist;

        public Edge(int start, int end, double dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            if (dist < o.dist) {
                return -1;
            }
            return 1;
        }
    }

    // 우주신들의 개수 N, 신들과의 통로 개수 M
    static int N, M;
    static int[] parents;
    static double answer = 0;
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list.add(new int[]{0, 0});

        make();

        // 우주신 좌표 저장
        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list.add(new int[]{A, B});
        }

        // 미리 연결된 통로 연결
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x, y);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        // 모든 좌표 거리 구하기
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j < N + 1; j++) {
                double dist = getDistance(list.get(i), list.get(j));
                pq.add(new Edge(i, j, dist));
            }
        }

        // 크루스칼
        while (!pq.isEmpty()) {
            Edge temp = pq.poll();

            if (union(temp.start, temp.end)) {
                answer += temp.dist;
            }
        }

        System.out.println(String.format("%.2f", answer));
    }

    private static double getDistance(int[] arr1, int[] arr2) {
        return Math.sqrt(Math.pow(arr1[0] - arr2[0], 2) + Math.pow(arr1[1] - arr2[1], 2));
    }

    private static void make() {
        parents = new int[N + 1];
        // 모든 원소를 자신을 대표자로 만듦
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static int find(int a) {
        if (a == parents[a]) return a;  // 자신이 대표자.
        return parents[a] = find(parents[a]);   // 자신이 속한 집합의 대표자를 자신의 부모로 : path compression
    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;   // 이미 같은 집합으로 합치지 않음

        parents[bRoot] = aRoot;
        return true;
    }

}