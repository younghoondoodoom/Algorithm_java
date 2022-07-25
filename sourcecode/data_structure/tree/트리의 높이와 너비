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
    int parent;
    int left;
    int right;

    public Node(int data, int left, int right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = -1;
    }

}

public class Main {

    static List<Node> tree = new ArrayList<>();
    static int[] maxDiff;
    static int[] minDiff;
    static int maxLevel = 0;
    static int point = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        maxDiff = new int[n + 1];
        minDiff = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            tree.add(new Node(i, -1, -1));
            maxDiff[i] = Integer.MIN_VALUE;
            minDiff[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < n + 1; i++) {
            List<Integer> inputs = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
            tree.get(inputs.get(0)).left = inputs.get(1);
            tree.get(inputs.get(0)).right = inputs.get(2);

            if (inputs.get(1) != -1) {
                tree.get(inputs.get(1)).parent = inputs.get(0);
            }
            if (inputs.get(2) != -1) {
                tree.get(inputs.get(2)).parent = inputs.get(0);
            }
        }

        int rootIdx = 0;
        for (int i = 1; i < n + 1; i++) {
            if (tree.get(i).parent == -1) {
                rootIdx = i;
                break;
            }
        }

        inorder(rootIdx, 1);

        int resultWidth = 0;
        int resultLevel = 0;

        for (int i = 1; i < maxLevel + 1; i++) {
            int width = maxDiff[i] - minDiff[i] + 1;
            if (width > resultWidth) {
                resultWidth = width;
                resultLevel = i;
            }
        }

        wr.write(resultLevel + " " + resultWidth);
        wr.flush();
        wr.close();
        br.close();

    }

    public static void inorder(int rootIdx, int level) {
        Node cur = tree.get(rootIdx);
        if (maxLevel < level) {
            maxLevel = level;
        }

        if (cur.left != -1) {
            inorder(cur.left, level + 1);
        }

        point++;
        minDiff[level] = Math.min(minDiff[level], point);
        maxDiff[level] = point;

        if (cur.right != -1) {
            inorder(cur.right, level + 1);
        }

    }



}

