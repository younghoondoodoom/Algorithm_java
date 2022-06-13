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

        char[] chars = br.readLine().toCharArray();

        for (char x : chars) {
            if ('a' <= x && 'z' >= x) {
                x += 13;
                if (x > 'z') {
                    x = (char) (('a' - 1) + (x - 'z'));
                }
            } else if ('A' <= x && 'Z' >= x) {
                x += 13;
                if (x > 'Z') {
                    x = (char) (('A' - 1) + (x - 'Z'));
                }
            }
            wr.write(x);
        }

        wr.flush();
        wr.close();
        br.close();

    }

}

