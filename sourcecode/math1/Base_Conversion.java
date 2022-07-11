package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] AB = br.readLine().split(" ");
        int A = Integer.parseInt(AB[0]);
        int B = Integer.parseInt(AB[1]);

        int m = Integer.parseInt(br.readLine());

        List<Integer> collect = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
            .collect(Collectors.toList());
        ArrayList<Integer> inputs = new ArrayList<>(collect);
        Collections.reverse(inputs);

        long demical = toDemical(inputs, A);
        ArrayList<Long> results = toN(demical, B);

        for (Long result : results) {
            wr.write(result + " ");
        }

        wr.flush();
        wr.close();
        br.close();
    }

    private static long toDemical(ArrayList<Integer> nums, int A) {
        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            result += Math.pow(A, i) * nums.get(i);
        }
        return result;
    }

    private static ArrayList<Long> toN(long demical, int B) {
        ArrayList<Long> result = new ArrayList<>();

        while (demical != 0) {
            long rest = demical % B;
            result.add(rest);
            demical /= B;
        }

        Collections.reverse(result);
        return result;
    }



}

