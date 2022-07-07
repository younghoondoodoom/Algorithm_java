package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        char[] N = inputs[0].toCharArray();
        long B = Long.parseLong(inputs[1]);

        long result = getResult(N, B);

        wr.write(result + "");
        wr.flush();
        wr.close();
        br.close();

    }

    private static long getResult(char[] N, long B) {
        long result = 0L;
        for (int i = 0; i < N.length; i++) {
            long num = -1;
            int j = N.length - 1 - i;
            if (N[i] >= '0' && N[i] <= '9') {
                num = ((long) N[i]) - 48;
            } else {
                num = ((long) N[i]) - 55;
            }
            long pow = (long) Math.pow(B, j);
            result += num * pow;
        }
        return result;
    }

}

