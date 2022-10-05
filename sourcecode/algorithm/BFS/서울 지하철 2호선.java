package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
        new OutputStreamWriter(System.out));

    static ArrayList<Integer>[] graph;
    static ArrayList<Integer> cycle = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
            graph[inputs[0]].add(inputs[1]);
            graph[inputs[1]].add(inputs[0]);
        }

        for (int i = 1; i <= n; i++) {
            if (!cycle.isEmpty()) {
                break;
            }
            ArrayList<Integer> visited = new ArrayList<>();
            visited.add(i);
            getCycle(i, i, visited);
        }

        for (int i = 1; i <= n; i++) {
            if (cycle.contains(i)) {
                wr.write(0 + " ");
            } else {
                wr.write(dfs(i, new boolean[n + 1]) + " ");
            }
        }

        wr.flush();
        wr.close();
        br.close();
    }

    private static int dfs(int i, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        int cnt = 1;

        int pollCnt = 1;
        while (!queue.isEmpty()) {
            int cnt2 = 0;
            for (int j = 0; j < pollCnt; j++) {
                Integer poll = queue.poll();
                for (Integer item : graph[poll]) {
                    if (!visited[item]) {
                        if (cycle.contains(item)) {
                            return cnt;
                        }
                        queue.add(item);
                        visited[item] = true;
                        cnt2++;
                    }
                }
            }
            pollCnt = cnt2;
            cnt++;
        }
        return cnt;
    }

    public static void getCycle(int cur, int start,
        ArrayList<Integer> visited) {
        for (Integer item : graph[cur]) {
            if (!visited.contains(item)) {
                ArrayList<Integer> copiedVisited = new ArrayList<>(visited);
                copiedVisited.add(item);
                getCycle(item, start, copiedVisited);
            } else if (item == start && visited.size() > 2) {
                cycle.addAll(visited);
                return;
            }
        }
    }

}

