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
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            List<Integer> input = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
            int max = input.stream().mapToInt(x -> x).max().getAsInt();
            int min = input.stream().mapToInt(x -> x).min().getAsInt();

            for (int j = max; j <= max*min; j += max) {
                if (j % min == 0) {
                    wr.write(j + "\n");
                    break;
                }
            }
        }

        wr.flush();
        wr.close();
        br.close();

    }

}

