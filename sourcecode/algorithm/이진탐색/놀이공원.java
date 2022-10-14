package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
            new OutputStreamWriter(System.out));

    static long[] times;
    static int m, n;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        times = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        if (n <= m) {
            wr.write(n + "");
        } else {
            long result = binarySearch();
            long child = getChildNumInTime(result - 1);

            for (int i = 0; i < m; i++) {
                if (result % times[i] == 0) {
                    child++;
                }
                if (child == n) {
                    wr.write(i + 1 + "");
                    break;
                }
            }
        }


        wr.flush();
        wr.close();
        br.close();
    }

    private static long binarySearch() {
        long left = 0L;
        long right = n * 30L;
        while (left <= right) {
            long mid = (left + right) / 2;

            long cnt = getChildNumInTime(mid);

            if (cnt >= n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static long getChildNumInTime(long t) {
        long cnt = m;

        for (long time : times) {
            cnt += t / time;
        }
        return cnt;
    }

}

