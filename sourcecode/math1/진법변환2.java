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

        List<Long> inputs = Arrays.stream(br.readLine().split(" ")).map(x -> Long.parseLong(x)).collect(
            Collectors.toList());

        long N = inputs.get(0);
        long B = inputs.get(1);

        ArrayList<String> result = getResult(N, B);
        for (String x : result) {
            wr.write(x);
        }

        wr.flush();
        wr.close();
        br.close();
    }

    static ArrayList<String> getResult(long N, long B) {
        ArrayList<String> result = new ArrayList<>();
        while (N != 0) {
            long x = N % B;
            if (x >= 10) {
                x += 55;
                char toChar = (char) x;
                result.add(String.valueOf(toChar));
            } else {
                result.add(String.valueOf(x));
            }
            N /= B;
        }
        Collections.reverse(result);
        return result;
    }

}

