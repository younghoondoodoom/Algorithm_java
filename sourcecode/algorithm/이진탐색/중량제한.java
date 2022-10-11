package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
        new OutputStreamWriter(System.out));

    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static boolean[] visited;
    static int start, end;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int left = 0;
        int right = -1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[]{b, limit});
            graph.get(b).add(new int[]{a, limit});

            right = Math.max(right, limit);
        }

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        while (left <= right) {
            int mid = (left + right) / 2;
            visited = new boolean[n + 1];

            if (bfs(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        wr.write(right + "");
        wr.flush();
        wr.close();
        br.close();
    }

    private static boolean bfs(int limit) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            if (poll == end) {
                return true;
            }

            ArrayList<int[]> list = graph.get(poll);

            for (int[] item : list) {
                if (!visited[item[0]] && limit <= item[1]) {
                    q.offer(item[0]);
                    visited[item[0]] = true;
                }
            }
        }

        return false;
    }

}

