package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        double left = 0, right = Math.min(x, y);

        while (right - left >= 0.001) {
            double width = (left + right) / 2;

            double h1 = Math.sqrt(Math.pow(x, 2) - Math.pow(width, 2));
            double h2 = Math.sqrt(Math.pow(y, 2) - Math.pow(width, 2));
            double result = (h1 * h2) / (h1 + h2);

            if (result >= c) {
                left = width;
            } else {
                right = width;
            }
        }

        wr.write(String.format("%.3f", right));
        wr.flush();
        wr.close();
        br.close();
    }

}

