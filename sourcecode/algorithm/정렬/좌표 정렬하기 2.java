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

        int[][] coordinates = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            coordinates[i][0] = Integer.parseInt(inputs[0]);
            coordinates[i][1] = Integer.parseInt(inputs[1]);
        }

        int[][] tmp = new int[n][2];

        mergeSort(coordinates, tmp, 0, n - 1);

        for (int[] coordinate : coordinates) {
            wr.write(coordinate[0] + " " + coordinate[1] + "\n");
        }

        wr.flush();
        wr.close();
        br.close();

    }

    private static void mergeSort(int[][] coordinates, int[][] tmp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(coordinates, tmp, left, mid);
            mergeSort(coordinates, tmp, mid + 1, right);
            merge(coordinates, tmp, left, right, mid);
        }
    }

    private static void merge(int[][] coordinates, int[][] tmp, int left, int right, int mid) {
        int p = left;
        int q = mid + 1;
        int idx = left;

        while (p <= mid || q <= right) {
            if (p <= mid && q <= right) {
                if (coordinates[p][1] == coordinates[q][1]) {
                    if (coordinates[p][0] < coordinates[q][0]) {
                        tmp[idx++] = coordinates[p++];
                    } else {
                        tmp[idx++] = coordinates[q++];
                    }
                } else if (coordinates[p][1] < coordinates[q][1]) {
                    tmp[idx++] = coordinates[p++];
                } else {
                    tmp[idx++] = coordinates[q++];
                }
            } else if (p <= mid) {
                tmp[idx++] = coordinates[p++];
            } else {
                tmp[idx++] = coordinates[q++];
            }
        }

        for (int i = left; i <= right; i++) {
            coordinates[i] = tmp[i];
        }
    }


}

