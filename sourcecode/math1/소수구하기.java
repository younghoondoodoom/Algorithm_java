package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> input = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
            .collect(Collectors.toList());

        int min = input.get(0);
        int max = input.get(1);

        boolean arr[] = new boolean[max + 1];
        arr[0] = arr[1] = true;

        // 에라토스테네스의 체 사용
        int sqrt = (int) Math.sqrt(max);
        for (int i = 2; i <= sqrt; i++) {
            for (int j = 2; j <= max/i; j++) {
                if (arr[i * j] == true) {
                    continue;
                } else {
                    arr[i * j] = true;
                }
            }
        }

        for (int i = min; i <= max; i++) {
            if (arr[i] == false) {
                wr.write(i + "\n");
            }
        }

        wr.flush();
        wr.close();
        br.close();
    }

}

