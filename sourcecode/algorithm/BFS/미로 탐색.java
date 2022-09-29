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

    static int h;
    static int w;
    static int[][] map;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new int[h][w];

        for (int i = 0; i < h; i++) {
            map[i] = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt).toArray();
        }

        visited = new boolean[h][w];
        visited[0][0] = true;
        bfs(0, 0);

        System.out.println(Arrays.deepToString(map));

        wr.write(map[h - 1][w - 1] + "");
        wr.flush();
        wr.close();
        br.close();
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            if (curX - 1 >= 0 && !visited[curX - 1][curY]
                && map[curX - 1][curY] == 1) {
                queue.add(new int[]{curX - 1, curY});
                visited[curX - 1][curY] = true;
                map[curX - 1][curY] = map[curX][curY] + 1;
            }
            if (curX + 1 <= h - 1 && !visited[curX + 1][curY]
                && map[curX + 1][curY] == 1) {
                queue.add(new int[]{curX + 1, curY});
                visited[curX + 1][curY] = true;
                map[curX + 1][curY] = map[curX][curY] + 1;
            }
            if (curY - 1 >= 0 && !visited[curX][curY - 1]
                && map[curX][curY - 1] == 1) {
                queue.add(new int[]{curX, curY - 1});
                visited[curX][curY - 1] = true;
                map[curX][curY - 1] = map[curX][curY] + 1;
            }
            if (curY + 1 <= w - 1 && !visited[curX][curY + 1]
                && map[curX][curY + 1] == 1) {
                queue.add(new int[]{curX, curY + 1});
                visited[curX][curY + 1] = true;
                map[curX][curY + 1] = map[curX][curY] + 1;
            }
        }
    }


}

