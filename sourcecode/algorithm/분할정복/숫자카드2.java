package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        List<Integer> input = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
            .collect(Collectors.toList());

        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer item : input) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());

        List<Integer> q = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
            .collect(Collectors.toList());

        List<Integer> keyList = new ArrayList<>(map.keySet().stream().collect(Collectors.toList()));
        Collections.sort(keyList);

        for (Integer item : q) {
            if (binarySearch(item, keyList)) {
                wr.write(map.get(item) + " ");
            } else {
                wr.write("0 ");
            }
        }

        wr.flush();
        wr.close();
        br.close();
    }

    private static boolean binarySearch(Integer item, List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (item < list.get(mid)) {
                right = mid - 1;
            } else if (item > list.get(mid)) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }


}

