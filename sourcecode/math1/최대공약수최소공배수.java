package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(x);
        list.add(y);

        int min = list.stream().mapToInt(a -> a).min().getAsInt();
        int max = list.stream().mapToInt(a -> a).max().getAsInt();

        for (int i = min; i >= 1; i--) {
            if (min % i == 0 && max % i == 0) {
                wr.write(i + "\n");
                break;
            }
        }

        for (int i = max; i <= max*min; i += max) {
            if (i % min == 0) {
                wr.write(i + "\n");
                break;
            }
        }

        wr.flush();
        wr.close();
        br.close();

    }

}

