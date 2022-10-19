package org.example;

import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
            new OutputStreamWriter(System.out));

    static int[][] board;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for(int i=0; i < n; i++){
            String s = br.readLine();
            for(int j=0; j < n; j++){
                char c = s.charAt(j);
                if(c == 'T'){
                    board[i][j] = 1;
                }
            }
        }

        int ans = 400;

        // 행을 뒤집을 것인가 뒤집지 않을 것인가를 비트 마스크로 결정
        for (int bit = 0; bit < (1 << n); bit++) {
            int sum = 0;

            // 현재 비트값에 대해 모든 열에서 탐색 수행
            for (int i = 0; i < n; i++) {
                int tail = 0;

                // 각 열의 행을 뒤집거나 뒤집지 않거나 수행
                for (int j = 0; j < n; j++) {
                    int cur = board[j][i];
                    // 비트가 1이면 뒤집는다.
                    if ((bit & (1 << j)) != 0) {
                        cur = flip(j, i);
                    }
                    // tail의 수를 찾는다
                    if (cur == 1) {
                        tail++;
                    }
                }
                sum += Math.min(tail, n - tail);
            }
            ans = Math.min(ans, sum);
        }

        wr.write(ans + "");
        wr.flush();
        wr.close();
        br.close();
    }

    private static int flip(int j, int i) {
        return board[j][i] ^ 1;
    }


}

