import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        int[] result = new int[n]; // 결과 값을 받을 list

        int[] list = new int[n]; // 입력 값을 받을 list

        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(inputs[i]);
        }

        int[] num_count = new int[1000001];

        for (int i : list) {
            num_count[i] += 1;
        }

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && num_count[list[i]] > num_count[list[stack.peek()]]) {
                result[stack.pop()] = list[i];
            }
            stack.add(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        for (int i : result) {
            wr.write(i + " ");
        }

        wr.flush();
        wr.close();
        br.close();

    }

}
