import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> stack = new Stack<>();
        String[] input = br.readLine().split("");
        boolean flag = true;
        int count = 0;

        for (String s : input) {
            if (s.contentEquals("(")) {
                flag = true;
                stack.push(s);
            } else if (s.contentEquals(")")) {
                stack.pop();
                if (flag) {
                    count += stack.size();
                } else {
                    count += 1;
                }
                flag = false;
            }
        }

        wr.write(count + "\n");
        wr.flush();
        wr.close();
        br.close();

    }

}

class StackClass {

    Stack<String> stack = new Stack<>();

    public void push() {
        stack.push("(");
    }


}

