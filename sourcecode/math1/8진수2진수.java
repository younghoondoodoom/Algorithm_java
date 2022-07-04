package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split("");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < inputs.length; i++) {
            int input = Integer.parseInt(inputs[i]);
            StringBuilder result = new StringBuilder();
            if (input >= 4) {
                result.append("1");
                input -= 4;
            } else {
                result.append("0");
            }
            if (input >= 2) {
                result.append("1");
                input -= 2;
            } else {
                result.append("0");
            }
            if (input >= 1) {
                result.append("1");
                input -= 1;
            } else {
                result.append("0");
            }

            sb.append(result.toString());
        }

        String result = sb.toString();

        if (result.equals("000")) {
            result = "0";
        } else {
            while (result.startsWith("0")) {
                result = result.substring(1);
            }
        }

        wr.write(result);
        wr.flush();
        wr.close();
        br.close();

    }

}

