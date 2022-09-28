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

    static int[] team;
    static ArrayList<Integer>[] graph;
    static final int RED = 1, BLUE = -1;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(
                br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph = new ArrayList[v + 1];
            team = new int[v + 1];

            for (int j = 0; j <= v; j++) {
                graph[j] = new ArrayList<Integer>();
            }

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                graph[n1].add(n2);
                graph[n2].add(n1);
            }

            String result = "YES";

            for (int j = 1; j <= v; j++) {
                if (team[j] == 0) {
                    if (!bfs(j)) {
                        result = "NO";
                        break;
                    }
                }
            }

            wr.write(result + "\n");

        }

        wr.flush();
        wr.close();
        br.close();
    }

    public static boolean bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        team[n] = RED;

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            ArrayList<Integer> relates = graph[cur];

            for (Integer relate : relates) {
                if (team[relate] == team[cur]) {
                    return false;
                }
                if (team[relate] == 0) {
                    team[relate] = team[cur] * -1;
                    queue.add(relate);
                }
            }
        }

        return true;
    }


}

