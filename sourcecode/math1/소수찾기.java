import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> input = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
            .collect(Collectors.toList());
        int cnt = 0;

        for (int i : input) {
            boolean flag = true;
            if (i == 1) {
                flag = false;
            }

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                cnt++;
            }

        }

        wr.write(cnt + "");
        wr.flush();
        wr.close();
        br.close();
    }

}
