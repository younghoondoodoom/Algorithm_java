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

        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            n = 1;
        } else {
            for (int i = n-1; i > 0; i--) {
                n *= i;
            }
        }

        wr.write(n + "");
        wr.flush();
        wr.close();
        br.close();

    }

}

