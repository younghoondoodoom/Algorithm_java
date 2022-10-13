package org.example;

import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
            new OutputStreamWriter(System.out));

    static long n;
    public static void main(String[] args) throws IOException {

        n = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());

        long left = 1L;
        long right = (long) Math.pow(n, 2);

        while (left < right) {
            long mid = (left + right) / 2;

            long cnt = getIdx(mid);

            if (cnt < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        wr.write(left + "");
        wr.flush();
        wr.close();
        br.close();
    }

    private static long getIdx(long mid) {
        long cnt = 0L;
        for (long i = 1L; i <= n; i++) {
            cnt += Math.min(mid / i, n);
        }
        return cnt;
    }

}

