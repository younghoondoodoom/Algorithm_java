import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";
        while ((input = br.readLine()) != null) {
            char[] chars = input.toCharArray();
            int small = 0, big = 0, num = 0, space = 0;
            for (char x : chars) {
                if ('a' <= x && x <= 'z') {
                    small += 1;
                } else if ('A' <= x && x <= 'Z') {
                    big += 1;
                } else if ('0' <= x && x <= '9') {
                    num += 1;
                } else {
                    space += 1;
                }
            }

            wr.write(small + " " + big + " " + num + " " + space + "\n");
            wr.flush();
        }

        wr.close();
        br.close();

    }

}

