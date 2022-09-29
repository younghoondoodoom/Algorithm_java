package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
        new OutputStreamWriter(System.out));

    static int[][] map;
    public static void main(String[] args) throws IOException {

        String input = null;

        while (!(input = br.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            }
            wr.write(getLandCnt() + "\n");
        }

        wr.flush();
        wr.close();
        br.close();
    }

    private static int getLandCnt() {
        int cnt = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }

        return cnt;
    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        map[x][y] = 0;

        while (!queue.isEmpty()) {
            Node p = queue.poll();

            if (p.x - 1 >= 0 && map[p.x - 1][p.y] == 1) {
                queue.offer(new Node(p.x - 1, p.y));
                map[p.x - 1][p.y] = 0;
            }
            if (p.x + 1 <= map.length - 1 && map[p.x + 1][p.y] == 1) {
                queue.offer(new Node(p.x + 1, p.y));
                map[p.x + 1][p.y] = 0;
            }
            if (p.y - 1 >= 0 && map[p.x][p.y - 1] == 1) {
                queue.offer(new Node(p.x, p.y - 1));
                map[p.x][p.y - 1] = 0;
            }
            if (p.y + 1 <= map[0].length - 1 && map[p.x][p.y + 1] == 1) {
                queue.offer(new Node(p.x, p.y + 1));
                map[p.x][p.y + 1] = 0;
            }
            if (p.x - 1 >= 0 && p.y - 1 >= 0
                && map[p.x - 1][p.y - 1] == 1) {
                queue.offer(new Node(p.x - 1, p.y - 1));
                map[p.x - 1][p.y - 1] = 0;
            }
            if (p.x - 1 >= 0 && p.y + 1 <= map[0].length - 1
                && map[p.x - 1][p.y + 1] == 1) {
                queue.offer(new Node(p.x - 1, p.y + 1));
                map[p.x - 1][p.y + 1] = 0;
            }
            if (p.x + 1 <= map.length - 1 && p.y - 1 >= 0
                && map[p.x + 1][p.y - 1] == 1) {
                queue.offer(new Node(p.x + 1, p.y - 1));
                map[p.x + 1][p.y - 1] = 0;
            }
            if (p.x + 1 <= map.length - 1 && p.y + 1 <= map[0].length - 1
                && map[p.x + 1][p.y + 1] == 1) {
                queue.offer(new Node(p.x + 1, p.y + 1));
                map[p.x + 1][p.y + 1] = 0;
            }

        }
    }

    static class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}

