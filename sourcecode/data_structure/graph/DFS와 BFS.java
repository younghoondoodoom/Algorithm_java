package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {

    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> NMV = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
            .collect(Collectors.toList());

        graph = new ArrayList[NMV.get(0) + 1];

        for (int i = 0; i < NMV.get(0) + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < NMV.get(1); i++) {
            List<Integer> inputs = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
            graph[inputs.get(0)].add(inputs.get(1));
            graph[inputs.get(1)].add(inputs.get(0));
        }

        DFS(new boolean[NMV.get(0) + 1], NMV.get(2));
        System.out.println();
        BFS(new boolean[NMV.get(0) + 1], NMV.get(2));
    }

    public static void DFS(boolean[] visited, int node) {
        visited[node] = true;
        System.out.print(node + " ");

        graph[node].sort(Comparator.naturalOrder());
        for (Integer next : graph[node]) {
            if (!visited[next]) {
                DFS(visited, next);
                visited[next] = true;
            }
        }
    }

    public static void BFS(boolean[] visited, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            System.out.print(cur + " ");
            graph[cur].sort(Comparator.naturalOrder());
            for (Integer next : graph[cur]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }

}

