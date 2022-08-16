package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        long[][] meets = new long[n][2];

        for (int i = 0; i < n; i++) {
            long[] meet = new long[2];
            String[] inputs = br.readLine().split(" ");
            meet[0] = Long.parseLong(inputs[0]);
            meet[1] = Long.parseLong(inputs[1]);
            meets[i] = meet;
        }

        Arrays.sort(meets, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[1] - o2[1] != 0) {
                    return (int) (o1[1] - o2[1]);
                } else {
                    return (int) (o1[0] - o2[0]);
                }
            }
        });

        int cnt = 0;
        long curTime = 0;

        for (int i = 0; i < meets.length; i++) {
            if (meets[i][0] >= curTime) {
                curTime = meets[i][1];
                cnt++;
            }
        }

        wr.write(cnt + "");
        wr.flush();
        wr.close();
        br.close();
    }


}

