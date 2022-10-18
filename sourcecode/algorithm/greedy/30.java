package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
            new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split("");

        Arrays.sort(input, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        int sum = 0;
        boolean flag = false;
        for (String s : input) {
            if (s.equals("0")) {
                flag = true;
            }
            sum += Integer.parseInt(s);
        }

        if (flag && sum % 3 == 0) {
            StringBuilder sb = new StringBuilder();
            for (String s : input) {
                sb.append(s);
            }
            wr.write(sb.toString());
        } else {
            wr.write("-1");
        }

        wr.flush();
        wr.close();
        br.close();
    }

}

