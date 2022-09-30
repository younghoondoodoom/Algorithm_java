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

    static int m;
    static int n;
    static int[][] box;
    static int days = 0;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        box = new int[n][m];

        for (int i = 0; i < n; i++) {
            box[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }

        bfs();

        boolean flag = true;

        for (int[] ints : box) {
            for (int item : ints) {
                if (item == 0) {
                    flag = false;
                    break;
                }
            }
        }

        if (!flag) {
            wr.write(-1 + "");
        } else {
            wr.write(days + "");
        }

        wr.flush();
        wr.close();
        br.close();
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 1) {
                    cnt++;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int cnt2 = 0;
            for (int i = 0; i < cnt; i++) {
                int[] p = queue.poll();
                // 위
                if (p[0] > 0 && box[p[0] - 1][p[1]] == 0) {
                    cnt2++;
                    box[p[0] - 1][p[1]] = 1;
                    queue.offer(new int[]{p[0] - 1, p[1]});
                }
                // 아래
                if (p[0] < n - 1 && box[p[0] + 1][p[1]] == 0) {
                    cnt2++;
                    box[p[0] + 1][p[1]] = 1;
                    queue.offer(new int[]{p[0] + 1, p[1]});
                }
                // 좌
                if (p[1] > 0 && box[p[0]][p[1] - 1] == 0) {
                    cnt2++;
                    box[p[0]][p[1] - 1] = 1;
                    queue.offer(new int[]{p[0], p[1] - 1});
                }
                // 우
                if (p[1] < m - 1 && box[p[0]][p[1] + 1] == 0) {
                    cnt2++;
                    box[p[0]][p[1] + 1] = 1;
                    queue.offer(new int[]{p[0], p[1] + 1});
                }
            }
            cnt = cnt2;
            if (cnt2 > 0) {
                days++;
            }
        }
    }


}

