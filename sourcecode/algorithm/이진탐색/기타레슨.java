package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
        new OutputStreamWriter(System.out));

    static int[] lectures;
    static int m;
    static int n;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lectures = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        int sum = Arrays.stream(lectures).sum();
        int max = Arrays.stream(lectures).max().getAsInt();

        int result = binarySearch(max, sum);

        wr.write(result + "");
        wr.flush();
        wr.close();
        br.close();
    }

    private static int binarySearch(int left, int right) {

        while (left <= right) {
            int mid = (left + right) / 2;

            // 최대값이 mid일 경우 블루레이 개수 구하기
            int sum = 0;
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                if (sum + lectures[i] > mid) {
                    cnt++;
                    sum = 0;
                }
                sum += lectures[i];
            }

            if (cnt > m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;

    }


}

