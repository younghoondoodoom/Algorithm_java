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

class Node {

    int data;
    int cost;

    public Node(int data, int cost) {
        this.data = data;
        this.cost = cost;
    }

}

public class Main {

    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int maxLen = 0;
    static int maxNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            tree[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < n - 1; i++) {
            List<Integer> inputs = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
            tree[inputs.get(0)].add(new Node(inputs.get(1), inputs.get(2)));
            tree[inputs.get(1)].add(new Node(inputs.get(0), inputs.get(2)));
        }

        visited = new boolean[n + 1];
        DFS(1, 0);

        visited = new boolean[n + 1];
        DFS(maxNode, 0);

        wr.write(maxLen + "");
        wr.flush();
        wr.close();
        br.close();
    }

    public static void DFS(int node, int len) {
        if (maxLen < len) {
            maxLen = len;
            maxNode = node;
        }

        visited[node] = true;

        for (Node relate : tree[node]) {
            if (!visited[relate.data]) {
                DFS(relate.data, len + relate.cost);
            }
        }
    }


}

