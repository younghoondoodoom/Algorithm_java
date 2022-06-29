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

        String[] s = br.readLine().split(" ");
        Long N = Long.parseLong(s[0]);
        Long S = Long.parseLong(s[1]);

        String[] loc = br.readLine().split(" ");
        ArrayList<Long> diffs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            Long diff = Math.abs(S - Integer.parseInt(loc[i]));
            diffs.add(diff);
        }

        Long result = diffs.get(0);
        for (int i = 1; i < N; i++) {
            result = GCD(result, diffs.get(i));
        }

        wr.write(result + "");

        wr.flush();
        wr.close();
        br.close();

    }

    private static Long GCD(Long a, Long b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

}

