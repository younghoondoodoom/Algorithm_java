package org.example;

import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
            new OutputStreamWriter(System.out));

    static boolean[][] board;
    static int n;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        board = new boolean[n + 1][n + 1];

        recursion(1, 1, n);

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (board[i][j]) {
                    wr.write(" ");
                } else {
                    wr.write("*");
                }
            }
            wr.write("\n");
        }

        wr.flush();
        wr.close();
        br.close();
    }

    private static void recursion(int xStart, int yStart, int m) {
        if (m == 1) {
            return;
        }
        for (int i = xStart + m / 3; i < xStart + 2 * m / 3; i++) {
            for (int j = yStart + m / 3; j < yStart + 2 * m / 3; j++) {
                board[i][j] = true;
            }
        }

        for (int i = xStart; i < xStart + m; i += m / 3) {
            for (int j = yStart; j < yStart + m; j += m / 3) {
                recursion(i, j, m / 3);
            }
        }
    }

}

