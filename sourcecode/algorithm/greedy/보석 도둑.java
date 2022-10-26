package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
            new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Jewelry[] jewelries = new Jewelry[n];
        Long[] bags = new Long[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewelries[i] = new Jewelry(Long.parseLong(st.nextToken()),
                    Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            bags[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(bags);
        Arrays.sort(jewelries, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                if (Objects.equals(o1.weight, o2.weight)) {
                    return (int) (o2.price - o1.price);
                }
                return (int) (o1.weight - o2.weight);
            }
        });

        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long result = 0L;

        for (int i = 0, j = 0; i < m; i++) {
            while (j < n && jewelries[j].weight <= bags[i]) {
                pq.offer(jewelries[j++].price);
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        wr.write(result + "");
        wr.flush();
        wr.close();
        br.close();
    }

    static class Jewelry {
        Long weight;
        Long price;

        public Jewelry(Long weight, Long price) {
            this.weight = weight;
            this.price = price;
        }
    }

}

