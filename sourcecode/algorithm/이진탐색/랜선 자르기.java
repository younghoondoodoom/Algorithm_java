
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] lans;

    public static void main(String[] args) throws IOException {

        String[] KN = br.readLine().split(" ");

        int k = Integer.parseInt(KN[0]);
        int n = Integer.parseInt(KN[1]);

        lans = new int[k];

        long max = 0;

        for (int i = 0; i < k; i++) {
            lans[i] = Integer.parseInt(br.readLine());
            if (max < lans[i]) {
                max = lans[i];
            }
        }

        long min = 0;
        max++;

        while (min < max) {
            long mid = (min + max) / 2;

            long count = 0;

            for (int i = 0; i < lans.length; i++) {
                count += lans[i] / mid;
            }

            if (count < n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        wr.write(min - 1 + "");
        wr.flush();
        wr.close();
        br.close();
    }

}

