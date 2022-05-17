import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        wr.write("<");
        while (queue.size() > 0) {
            for (int i = 0; i < k-1; i++) {
                queue.add(queue.poll());
            }
            if (queue.size() == 1) {
                wr.write(queue.poll() + ">");
            } else {
                wr.write(queue.poll() + ", ");
            }
        }

        wr.flush();
        wr.close();
        br.close();
    }

}
