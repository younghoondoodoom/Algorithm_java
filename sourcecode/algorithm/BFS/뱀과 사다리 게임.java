package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
            new OutputStreamWriter(System.out));
    static Map<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new HashMap<>();

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        wr.write(bfs() + "");
        wr.flush();
        wr.close();
        br.close();
    }

    private static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int result = 0;
        int cnt = 1;
        boolean[] visited = new boolean[101];
        visited[1] = true;

        while (!q.isEmpty()) {
            int cnt2 = 0;
            for (int i = 0; i < cnt; i++) {
                Integer poll = q.poll();
                if (poll == 100) {
                    return result;
                }

                for (int j = 1; j <= 6; j++) {
                    if (poll + j > 100 || poll + j <= 0 || visited[poll + j]) {
                        continue;
                    }
                    if (map.containsKey(poll + j)) {
                        q.add(map.get(poll + j));
                        visited[map.get(poll + j)] = true;
                    } else {
                        q.add(poll + j);
                        visited[poll + j] = true;
                    }
                    cnt2++;
                }
            }
            cnt = cnt2;
            result++;
        }
        return result;
    }

}

