package org.example;

import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
            new OutputStreamWriter(System.out));

    static int[] xMove = {-1, 1, 0, 0};
    static int[] yMove = {0, 0, -1, 1};
    static int n;
    static String[][] board;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        board = new String[n][n];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().split("");
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, getLongest(i, j));
            }
        }

        wr.write(max + "");
        wr.flush();
        wr.close();
        br.close();
    }

    private static int getLongest(int i, int j) {
        int max = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + xMove[k];
            int y = j + yMove[k];

            if (x < 0 || y < 0 || x >= n || y >= n || board[i][j].equals(board[x][y])) {
                continue;
            }
            convert(i, j, x, y);

            max = Math.max(max, getLength());

            convert(i, j, x, y);
        }

        return max;
    }

    private static void convert(int i, int j, int x, int y) {
        String s = board[i][j];
        board[i][j] = board[x][y];
        board[x][y] = s;
    }

    private static int getLength() {
        int maxCnt = 1;

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            String prev = board[i][0];
            for (int j = 1; j < n; j++) {
                if (board[i][j].equals(prev)) {
                    cnt++;
                    maxCnt = Math.max(maxCnt, cnt);
                } else {
                    prev = board[i][j];
                    cnt = 1;
                }
            }
            cnt = 1;
            prev = board[0][i];
            for (int j = 1; j < n; j++) {
                if (board[j][i].equals(prev)) {
                    cnt++;
                    maxCnt = Math.max(maxCnt, cnt);
                } else {
                    prev = board[j][i];
                    cnt = 1;
                }
            }
        }

        return maxCnt;
    }

}

