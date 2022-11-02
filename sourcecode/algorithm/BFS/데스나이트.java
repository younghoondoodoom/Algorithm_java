package org.example;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
            new OutputStreamWriter(System.out));
    static int[] rMove = new int[]{-2, -2, 0, 0, 2, 2};
    static int[] cMove = new int[]{-1, 1, -2, 2, -1, 1};
    static int n;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        visited = new boolean[n][n];

        int result = bfs(r1, c1, r2, c2);

        wr.write(result + "");
        wr.flush();
        wr.close();
        br.close();
    }

    private static int bfs(int r1, int c1, int r2, int c2) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r1, c1});
        visited[r1][c1] = true;
        int result = 0;
        int cnt = 1;

        while (!q.isEmpty()) {
            int cnt2 = 0;
            for (int i = 0; i < cnt; i++) {
                int[] poll = q.poll();

                if (poll[0] == r2 && poll[1] == c2) {
                    return result;
                }

                for (int j = 0; j < 6; j++) {
                    int r = poll[0] + rMove[j];
                    int c = poll[1] + cMove[j];

                    if (r < 0 || c < 0 || r >= n || c >= n || visited[r][c]) {
                        continue;
                    }

                    q.add(new int[]{r, c});
                    visited[r][c] = true;
                    cnt2++;
                }
            }

            cnt = cnt2;
            result++;
        }

        return -1;
    }

}

