package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        Long t = Long.parseLong(br.readLine());

        for (int i = 0; i < t; i++) {
            List<Long> input = Arrays.stream(br.readLine().split(" "))
                .map(x -> Long.parseLong(x)).collect(Collectors.toList());
            Long n = input.get(0);
            Long sum = 0L;
            for (int j = 1; j < n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    Long result = GCD(input.get(j), input.get(k));
                    sum += result;
                }
            }
            wr.write(sum + "\n");
        }

        wr.flush();
        wr.close();
        br.close();

    }

    public static Long GCD(Long x, Long y) {
        Long max = Long.max(x, y);
        Long min = Long.min(x, y);
        Long result = 0L;
        for (Long i = min; i > 0; i--) {
            if (min % i == 0 && max % i == 0) {
                result = i;
                break;
            }
        }
        return result;
    }

}

