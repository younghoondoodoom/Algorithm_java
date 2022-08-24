package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static int cntMinus = 0;
    static int cntZero = 0;
    static int cntOne = 0;
    static int[][] matrix;
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        check(0, 0, matrix.length);

        wr.write(cntMinus + "\n");
        wr.write(cntZero + "\n");
        wr.write(cntOne + "\n");

        wr.flush();
        wr.close();
        br.close();
    }

    public static void check(int row, int col, int size) {
        int prev = matrix[row][col];
        boolean flag = true;
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (prev != matrix[i][j]) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        if (flag) {
            if (prev == -1) {
                cntMinus++;
            } else if (prev == 0) {
                cntZero++;
            } else {
                cntOne++;
            }
            return;
        }

        int s = size / 3;
        check(row, col, s);
        check(row, col + s, s);
        check(row, col + 2 * s, s);
        check(row + s, col, s);
        check(row + s, col + s, s);
        check(row + s, col + 2 * s, s);
        check(row + 2 * s, col, s);
        check(row + 2 * s, col + s, s);
        check(row + 2 * s, col + 2 * s, s);
    }

}

