import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] chars = br.readLine().toCharArray();

        for (char i = 'a'; i <= 'z'; i++) {
            int count = 0;
            for (char j : chars) {
                if (i == j) {
                    count += 1;
                }
            }
            wr.write(count + " ");
        }

        wr.flush();
        wr.close();
        br.close();

    }

}

