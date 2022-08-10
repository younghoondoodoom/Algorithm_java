package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList> members = new ArrayList<ArrayList>(n);

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            ArrayList list = new ArrayList();
            list.add(Integer.parseInt(inputs[0]));
            list.add(inputs[1]);
            members.add(list);
        }

        ArrayList<ArrayList> tmp = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            tmp.add(null);
        }

        mergeSort(members, tmp, 0, n - 1);

        for (ArrayList member : members) {
            wr.write(member.get(0) + " " + member.get(1) + "\n");
        }

        wr.flush();
        wr.close();
        br.close();

    }

    private static void mergeSort(ArrayList<ArrayList> members, ArrayList<ArrayList> tmp, int left,
        int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(members, tmp, left, mid);
            mergeSort(members, tmp, mid + 1, right);
            merge(members, tmp, left, right, mid);
        }
    }

    private static void merge(ArrayList<ArrayList> members, ArrayList<ArrayList> tmp, int left,
        int right, int mid) {
        int p = left;
        int q = mid + 1;
        int idx = left;

        while (p <= mid || q <= right) {
            if (p <= mid && q <= right) {
                if ((int) members.get(p).get(0) == (int) members.get(q).get(0)) {
                    if (p < q) {
                        tmp.set(idx++, members.get(p++));
                    } else {
                        tmp.set(idx++, members.get(q++));
                    }
                } else if ((int) members.get(p).get(0) < (int) members.get(q).get(0)) {
                    tmp.set(idx++, members.get(p++));
                } else {
                    tmp.set(idx++, members.get(q++));
                }
            } else if (p <= mid) {
                tmp.set(idx++, members.get(p++));
            } else {
                tmp.set(idx++, members.get(q++));
            }
        }

        for (int i = left; i <= right; i++) {
            members.set(i, tmp.get(i));
        }

    }

}

