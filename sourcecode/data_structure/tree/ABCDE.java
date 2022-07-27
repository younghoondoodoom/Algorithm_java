package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    static ArrayList<Integer>[] list;
    static int flag = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> NM = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
            .collect(Collectors.toList());

        list = new ArrayList[NM.get(0)];

        for (int i = 0; i < NM.get(0); i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < NM.get(1); i++) {
            List<Integer> inputs = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
            list[inputs.get(0)].add(inputs.get(1));
            list[inputs.get(1)].add(inputs.get(0));
        }

        for (int i = 0; i < NM.get(0); i++) {
            DFS(new boolean[NM.get(0)], i, 0);
            if (flag == 1) {
                break;
            }
        }

        wr.write(flag + "");
        wr.flush();
        wr.close();
        br.close();


    }

    public static void DFS(boolean[] visited, int node, int cnt) {
        if (cnt >= 4) {
            flag = 1;
            return;
        }

        visited[node] = true;

        for (Integer relate : list[node]) {
            if (!visited[relate]) {
                DFS(visited, relate, cnt + 1);
            }
        }

        visited[node] = false;
    }

}

