package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
        new OutputStreamWriter(System.out));

    static boolean[][] visited;
    static int[][] map;
    static ArrayList<Integer> result = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt).toArray();
        }

        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    result.add(BFS(i, j));
                }
            }
        }
        result.sort(Comparator.naturalOrder());
        wr.write(result.size() + "\n");
        for (Integer i : result) {
            wr.write(i + "\n");
        }

        wr.flush();
        wr.close();
        br.close();
    }

    public static int BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();

            if (p[0] - 1 >= 0 && map[p[0] - 1][p[1]] == 1 &&
                !visited[p[0] - 1][p[1]]) {
                queue.add(new int[]{p[0] - 1, p[1]});
                visited[p[0] - 1][p[1]] = true;
                cnt++;
            }
            if (p[0] + 1 < n && map[p[0] + 1][p[1]] == 1 &&
                !visited[p[0] + 1][p[1]]) {
                queue.add(new int[]{p[0] + 1, p[1]});
                visited[p[0] + 1][p[1]] = true;
                cnt++;
            }
            if (p[1] - 1 >= 0 && map[p[0]][p[1] - 1] == 1 &&
                !visited[p[0]][p[1] - 1]) {
                queue.add(new int[]{p[0], p[1] - 1});
                visited[p[0]][p[1] - 1] =true;
                cnt++;
            }
            if (p[1] + 1 < n && map[p[0]][p[1] + 1] == 1 &&
                !visited[p[0]][p[1] + 1]) {
                queue.add(new int[]{p[0], p[1] + 1});
                visited[p[0]][p[1] + 1] =true;
                cnt++;
            }
        }

        return cnt;
    }

}

