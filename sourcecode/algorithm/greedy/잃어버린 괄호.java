package org.example;

import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
            new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        String s = br.readLine();

        boolean minus = false;
        int plusSum = 0;
        int minusSum = 0;
        for (int i = 0; i < s.length(); i++) {
            // - 일 때
            if (s.charAt(i) == '-') {
                minus = true;
                continue;
            }

            // +
            if (s.charAt(i) == '+') {
                continue;
            }

            // 숫자일 때
            StringBuilder sb = new StringBuilder();
            while (i <= s.length() - 1 && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sb.append(s.charAt(i++));
            }

            if (minus) {
                minusSum += Integer.parseInt(sb.toString());
            } else {
                plusSum += Integer.parseInt(sb.toString());
            }
            i--;
        }

        wr.write(plusSum - minusSum + "");

        wr.flush();
        wr.close();
        br.close();
    }

}

