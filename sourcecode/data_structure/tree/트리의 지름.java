package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
    static boolean[] isVisited;
    static int max = 0;
    static int node;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        tree = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            while (true) {
                int data = sc.nextInt();
                if (data == -1) {
                    break;
                }
                int cost = sc.nextInt();
                tree[x].add(new Node(data, cost));
            }
        }

        isVisited = new boolean[n + 1];
        DFS(1, 0);

        isVisited = new boolean[n + 1];
        DFS(node, 0);

        System.out.println(max);
    }

    private static void DFS(int start, int len) {
        if (len > max) {
            max = len;
            node = start;
        }
        isVisited[start] = true;

        for (int i = 0; i < tree[start].size(); i++) {
            Node curNode = tree[start].get(i);
            if (!isVisited[curNode.data]) {
                DFS(curNode.data, len + curNode.cost);
            }
        }
    }

}

