package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            String x = input.substring(i, input.length());
            list.add(x);
        }

        Collections.sort(list);

        for (String x : list) {
            wr.write(x + "\n");
        }

        wr.flush();
        wr.close();
        br.close();

    }
}

