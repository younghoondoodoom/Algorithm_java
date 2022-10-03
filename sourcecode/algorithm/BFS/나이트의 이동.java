package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
        new OutputStreamWriter(System.out));

    static int[][] board;
    static boolean[][] visited;
    static int[] start;
    static int[] to;
    static int l;
    static int min = 0;
    static int[] xMove = new int[]{-1, -2, -2, -1, 2, 1, 2, 1};
    static int[] yMove = new int[]{-2, -1, 1, 2, 1, 2, -1, -2};

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            l = Integer.parseInt(br.readLine());
            board = new int[l][l];
            visited = new boolean[l][l];

            start = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
            to = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

            bfs();
            wr.write(min + "\n");
            min = 0;
        }

        wr.flush();
        wr.close();
        br.close();
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        int cnt = 1;
        boolean flag = false;

        while (!queue.isEmpty() && !flag) {
            int cnt2 = 0;
            for (int i = 0; i < cnt; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if (x == to[0] && y == to[1]) {
                    flag = true;
                    break;
                }

                for (int j = 0; j < xMove.length; j++) {
                    int a = x + xMove[j];
                    int b = y + yMove[j];

                    if (a < 0 || b < 0 || a > l - 1 || b > l - 1 || visited[a][b]) {
                        continue;
                    }

                    queue.offer(new int[]{a, b});
                    visited[a][b] = true;
                    cnt2++;
                }
            }

            cnt = cnt2;
            if (cnt2 > 0 && !flag) {
                min++;
            }
        }
    }

}

