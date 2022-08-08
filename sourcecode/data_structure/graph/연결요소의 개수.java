package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> NM = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
            .collect(Collectors.toList());

        graph = new ArrayList[NM.get(0) + 1];
        for (int i = 0; i < NM.get(0) + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < NM.get(1); i++) {
            List<Integer> inputs = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
            graph[inputs.get(0)].add(inputs.get(1));
            graph[inputs.get(1)].add(inputs.get(0));
        }

        visited = new boolean[NM.get(0) + 1];

        int cnt = 1;
        for (int i = 1; i < NM.get(0) + 1; i++) {
            if (visited[i]) {
                continue;
            }
            DFS(i);
            for (int j = 1; j < visited.length; j++) {
                if (!visited[j]) {
                    cnt++;
                    break;
                }
            }
        }

        wr.write(cnt + "");
        wr.flush();
        wr.close();
        br.close();

    }

    public static void DFS(int node) {
        visited[node] = true;

        for (Integer next : graph[node]) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }

}

