import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        ArrayList<Integer> toInt = new ArrayList<>();

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        int x = (a + b) % c;
        int y = ((a % c) + (b % c)) % c;
        int z = (a * b) % c;
        int q = ((a % c) * (b % c)) % c;

        wr.write(x + "\n");
        wr.write(y + "\n");
        wr.write(z + "\n");
        wr.write(q + "\n");
        wr.flush();
        wr.close();
        br.close();
    }

}

