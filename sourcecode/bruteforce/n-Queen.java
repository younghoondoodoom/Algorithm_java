package org.example;

import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
            new OutputStreamWriter(System.out));
    static int n;
    static int[] board;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new int[n];

        nQueen(0);

        wr.write(cnt + "");
        wr.flush();
        wr.close();
        br.close();
    }

    private static void nQueen(int row) {
        if (row == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            board[row] = i;
            if (isPromise(row)) {
                nQueen(row + 1);
            }
        }

    }

    private static boolean isPromise(int row) {
        for (int i = 0; i < row; i++) {
            if (board[row] == board[i] || row - i == Math.abs(board[row] - board[i])) {
                return false;
            }
        }
        return true;
    }

}

