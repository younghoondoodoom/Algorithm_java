package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
        new OutputStreamWriter(System.out));

    static int n;
    static int m;
    static String[][] board;
    static int[] xMove = new int[]{-1, 1, 0, 0};
    static int[] yMove = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new String[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().split("");
        }

        boolean flag = false;

        for (int i = 0; i < n; i++) {
            if (flag) {
                break;
            }
            for (int j = 0; j < m; j++) {
                boolean[][] visited = new boolean[n][m];
                visited[i][j] = true;
                if (dfs(i, j, 1, new int[]{i, j}, board[i][j], visited)) {
                    flag = true;
                    break;
                }
            }
        }

        if (flag) {
            wr.write("Yes");
        } else {
            wr.write("No");
        }

        wr.flush();
        wr.close();
        br.close();
    }

    public static boolean dfs(int x, int y, int cnt, int[] start, String color,
        boolean[][] visited) {
        for (int i = 0; i < 4; i++) {
            int x1 = x + xMove[i];
            int y1 = y + yMove[i];

            if (x1 < 0 || y1 < 0 || x1 >= n || y1 >= m || !board[x1][y1].equals(
                color)) {
                continue;
            }

            if (!visited[x1][y1]) {
                visited[x1][y1] = true;
                if (dfs(x1, y1, cnt + 1, start, color, visited)) {
                    return true;
                }
            } else if (start[0] == x1 && start[1] == y1 && cnt + 1 >= 4) {
                return true;
            }
        }

        return false;
    }

}

