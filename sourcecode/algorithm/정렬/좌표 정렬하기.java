package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] coordinates = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            coordinates[i] = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        }

        ArrayList<Integer>[] result = new ArrayList[n];

        mergeSort(coordinates, result, 0, coordinates.length - 1);

        for (ArrayList<Integer> coordinate : coordinates) {
            wr.write(coordinate.get(0) + " " + coordinate.get(1) + "\n");
        }

        wr.flush();
        wr.close();
        br.close();
    }

    private static void mergeSort(ArrayList<Integer>[] coordinates, ArrayList<Integer>[] result,
        int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(coordinates, result, left, mid);
            mergeSort(coordinates, result, mid + 1, right);
            merge(coordinates, result, left, right, mid);
        }
    }

    private static void merge(ArrayList<Integer>[] coordinates, ArrayList<Integer>[] result,
        int left, int right, int mid) {
        int p = left;
        int q = mid + 1;
        int idx = left;

        while (p <= mid || q <= right) {
            if (p <= mid && q <= right) {
                if (coordinates[p].get(0).equals(coordinates[q].get(0))) {
                    if (coordinates[p].get(1) < coordinates[q].get(1)) {
                        result[idx++] = coordinates[p++];
                    } else {
                        result[idx++] = coordinates[q++];
                    }
                } else if (coordinates[p].get(0) < coordinates[q].get(0)) {
                    result[idx++] = coordinates[p++];
                } else {
                    result[idx++] = coordinates[q++];
                }
            } else if (p <= mid && q > right) {
                result[idx++] = coordinates[p++];
            } else {
                result[idx++] = coordinates[q++];
            }
        }

        for (int i = left; i <= right; i++) {
            coordinates[i] = result[i];
        }
    }


}

