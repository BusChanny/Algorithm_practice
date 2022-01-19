import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18223_민준이와마산그리고건우 {
    static class Node implements Comparable<Node> {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    static int V, E, P;
    static int[] dist;
    static ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        list = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        int[] dist1 = dijkstra(1);
        int[] dist2 = dijkstra(P);
        // 건우를 구하고 마산까지 가는 거리가 민준이가 마산까지 가는 최단거리보다 작거나 같으면 구한다
        if (dist1[V] >= dist1[P] + dist2[V]) {
            System.out.println("SAVE HIM");
        }else {
            System.out.println("GOOD BYE");
        }
    }

    private static int[] dijkstra(int start) {
        dist = new int[V + 1];
        // 초기화
        for (int i = 1; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node temp = q.poll();
            for (Node n :
                    list[temp.end]) {
                if (dist[n.end] > n.weight + temp.weight) {
                    dist[n.end] = n.weight + temp.weight;
                    q.add(new Node(n.end, n.weight + temp.weight));
                }
            }
        }
        return dist;
    }
}
