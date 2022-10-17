package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
            new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                plus.add(num);
            } else {
                minus.add(num);
            }
        }

        plus.sort(Collections.reverseOrder());
        minus.sort(Comparator.naturalOrder());

        int result = 0;
        for (int i = 0; i < plus.size(); i++) {
            if (i + 1 < plus.size()) {
                Integer cur = plus.get(i);
                Integer next = plus.get(i + 1);

                if (cur + next < cur * next) {
                    result += cur * next;
                    i++;
                    continue;
                }
            }
            result += plus.get(i);
        }

        for (int i = 0; i < minus.size(); i++) {
            if (i + 1 < minus.size()) {
                result += minus.get(i) * minus.get(i + 1);
                i++;
                continue;
            }
            result += minus.get(i);
        }

        wr.write(result + "");

        wr.flush();
        wr.close();
        br.close();
    }

}

