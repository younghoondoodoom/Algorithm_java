import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
        new OutputStreamWriter(System.out));
    static int n, q;
    static List<Node>[] graph;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            graph[p].add(new Node(q, r));
            graph[q].add(new Node(p, r));
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            wr.write(bfs(k, v) + "\n");
        }

        wr.flush();
        wr.close();
        br.close();
    }

    public static int bfs(int k, int v) {
        boolean[] visited = new boolean[n + 1];
        int cnt = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(v, Integer.MAX_VALUE));

        while (!q.isEmpty()) {
            Node poll = q.poll();
            visited[poll.video] = true;
            for (Node node : graph[poll.video]) {
                if (visited[node.video]) {
                    continue;
                }
                int min = Math.min(node.dist, poll.dist);
                if (min >= k) {
                    cnt++;
                    q.add(new Node(node.video, min));
                    visited[node.video] = true;
                }
            }
        }

        return cnt;
    }

    static class Node{
        int video, dist;

        public Node(int video, int dist) {
            this.video = video;
            this.dist = dist;
        }
    }
}
