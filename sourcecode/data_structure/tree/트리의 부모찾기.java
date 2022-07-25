package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

class Node {

    int data;
    List<Integer> relates = new ArrayList<>();

    public Node(int data) {
        this.data = data;
    }
}
public class Main {
    static ArrayList<Node> tree = new ArrayList<>();
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        parents = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            tree.add(new Node(i));
        }

        for (int i = 1; i < n; i++) {
            List<Integer> inputs = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
            tree.get(inputs.get(0)).relates.add(inputs.get(1));
            tree.get(inputs.get(1)).relates.add(inputs.get(0));
        }

        BFS();

        for (int i = 2; i < n + 1; i++) {
            wr.write(parents[i] + "\n");
        }

        wr.flush();
        wr.close();
        br.close();

    }

    private static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            Node parent = tree.get(queue.poll());
            for (Integer relate : parent.relates) {
                if (parents[relate] == 0) {
                    parents[relate] = parent.data;
                    queue.offer(relate);
                }
            }
        }
    }



}

