package org.example;

import java.io.*;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
            new OutputStreamWriter(System.out));
    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 9; i++) {
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        sudoku(0, 0);
    }

    private static void sudoku(int row, int col) throws IOException {
        if (col == 9) {
            sudoku(row + 1, 0);
            return;
        }
        if (row == 9) {
            for (int[] item : board) {
                for (int i : item) {
                    wr.write(i + " ");
                }
                wr.write("\n");
            }

            wr.flush();
            wr.close();
            br.close();
            System.exit(0);
        }

        if (board[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isPromise(row, col, i)) {
                    board[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            board[row][col] = 0;
            return;
        }
        sudoku(row, col + 1);
    }

    private static boolean isPromise(int row, int col, int n) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == n || board[i][col] == n) {
                return false;
            }
        }

        int ind_row = (row/3)*3;
        int ind_col = (col/3)*3;

        for(int i = ind_row ; i < ind_row+3 ; i ++) {
            for(int j = ind_col ; j < ind_col +3 ; j++) {
                if(board[i][j] == n)
                    return false;
            }
        }
        return true;
    }

}

