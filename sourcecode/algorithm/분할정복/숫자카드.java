package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;


public class Main {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer> had;
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        had = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
            .collect(Collectors.toCollection(
                ArrayList::new));

        had.sort(Comparator.naturalOrder());

        int m = Integer.parseInt(br.readLine());

        ArrayList<Integer> given = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
            .collect(Collectors.toCollection(
                ArrayList::new));

        for (Integer item : given) {
            if (binarySearch(item)) {
                wr.write("1 ");
            } else {
                wr.write("0 ");
            }
        }

        wr.flush();
        wr.close();
        br.close();
    }

    private static boolean binarySearch(Integer item) {
        int leftIdx = 0;
        int rightIdx = had.size() - 1;

        while (leftIdx <= rightIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;

            if (item < had.get(midIdx)) {
                rightIdx = midIdx - 1;
            } else if (item > had.get(midIdx)) {
                leftIdx = midIdx + 1;
            } else {
                return true;
            }
        }

        return false;
    }


}

