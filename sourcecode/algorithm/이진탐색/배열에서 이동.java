package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
            new OutputStreamWriter(System.out));

    static int n;
    static int[][] board;
    static int[] xMove = new int[]{0, 0, 1, -1};
    static int[] yMove = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            board[i] =
                    Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            min = Math.min(min, Arrays.stream(board[i]).min().getAsInt());
            max = Math.max(max, Arrays.stream(board[i]).max().getAsInt());
        }

        int left = 0; // **
        int right = max - min;

        while (left <= right) {
            int mid = (left + right) / 2;
            boolean flag = false;
            for (int i = board[0][0] - mid; i <= board[0][0]; i++) {
                if (bfs(i, i + mid, new boolean[n][n])) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        wr.write(left + "");
        wr.flush();
        wr.close();
        br.close();
    }

    private static boolean bfs(int min, int max, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        boolean flag = false;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            if (poll[0] == n - 1 && poll[1] == n - 1) {
                flag = true;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int x = poll[0] + xMove[i];
                int y = poll[1] + yMove[i];

                if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y]) {
                    continue;
                }

                if (min > board[x][y] || max < board[x][y]) {
                    continue;
                }

                q.offer(new int[]{x, y});
                visited[x][y] = true;
            }
        }

        return flag;
    }


}

