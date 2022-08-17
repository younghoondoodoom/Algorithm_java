package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        char[] start = br.readLine().toCharArray();
        char[] target = br.readLine().toCharArray();

        char[] clone = start.clone();

        int result = check(start, target);

        if (result != -1) {
            wr.write(result + "");
        } else {
            reverse(clone, 0);
            int result1 = check(clone, target);
            if (result1 == -1) {
                wr.write(result1 + "");
            } else {
                wr.write((result1 + 1) + "");
            }
        }

        wr.flush();
        wr.close();
        br.close();
    }

    private static void reverse(char[] clone, int i) {
        if (clone[i] == '0') {
            clone[i] = '1';
        } else {
            clone[i] = '0';
        }

        if (i == 0) {
            if (clone[i + 1] == '0') {
                clone[i + 1] = '1';
            } else {
                clone[i + 1] = '0';
            }
        } else if (i == clone.length - 1) {
            if (clone[i - 1] == '0') {
                clone[i - 1] = '1';
            } else {
                clone[i - 1] = '0';
            }
        } else {
            if (clone[i + 1] == '0') {
                clone[i + 1] = '1';
            } else {
                clone[i + 1] = '0';
            }
            if (clone[i - 1] == '0') {
                clone[i - 1] = '1';
            } else {
                clone[i - 1] = '0';
            }
        }
    }

    private static int check(char[] start, char[] target) {
        int cnt = 0;
        for (int i = 1; i < start.length; i++) {
            if (start[i - 1] != target[i - 1]) {
                reverse(start, i);
                cnt++;
            }
        }

        for (int i = 0; i < start.length; i++) {
            if (start[i] != target[i]) {
                return -1;
            }
        }

        return cnt;
    }

}

