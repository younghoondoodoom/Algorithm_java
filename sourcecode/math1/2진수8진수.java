package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split("");
        ArrayList<String> input = new ArrayList<>();
        for (String s : inputs) {
            input.add(s);
        }

        StringBuilder resultbuilder = new StringBuilder();
        long result = 0;
        long count = 1;

        while (!input.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int size = input.size();
            if (size > 3) {
                for (int i = 0; i < 3; i++) {
                    sb.append(input.remove(input.size() - 1));
                }
            } else {
                for (int i = 0; i < size; i++) {
                    sb.append(input.remove(input.size() - 1));
                }
            }
            sb.reverse();

            Long binary = Long.valueOf(sb.toString(), 2);
            resultbuilder.append(binary);
        }

        resultbuilder.reverse();

        wr.write(resultbuilder.toString());
        wr.flush();
        wr.close();
        br.close();


    }

}

