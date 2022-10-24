package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
            new OutputStreamWriter(System.out));
    static int[] xMove = new int[]{2, -2, 1, -1};
    static int[] yMove = new int[]{1, 1, 2, 2};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (n < 3 || m < 7) {
            wr.write(recursion(0, 0, 1) + "");
        } else {
            int cnt = 5;
            int x = 0;
            int y = 6;
            while (true) {
                boolean flag = false;
                for (int i = 0; i < 4; i++) {
                    int x1 = x + xMove[i];
                    int y1 = y + yMove[i];
                    if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) {
                        continue;
                    }
                    cnt++;
                    x = x1;
                    y = y1;
                    flag = true;
                    break;
                }

                if (!flag) {
                    break;
                }
            }
            wr.write(cnt + "");
        }

        wr.flush();
        wr.close();
        br.close();
    }

    private static int recursion(int x, int y, int cnt) {
        if (cnt > 4) {
            return 4;
        }
        int max = cnt;
        for (int i = 0; i < 4; i++) {
            int x1 = x + xMove[i];
            int y1 = y + yMove[i];
            if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) {
                continue;
            }
            max = Math.max(max, recursion(x1, y1, cnt + 1));
        }
        return max;
    }


}

