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

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        if (N == 0) {
            sb.append(0);
        } else {
            while (N != 1) {
                int rest = Math.abs(N % -2);
                N = (int)(Math.ceil((double)N/-2));
                sb.append(rest);
            }
            sb.append(N);
        }

        wr.write(String.valueOf(sb.reverse()));
        wr.flush();
        wr.close();
        br.close();
    }

}

