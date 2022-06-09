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
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split("");

        Stack<String> stack = new Stack<>();

        for (String s : input) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(s)) {
                    sb.append(stack.pop());
                }
                stack.push(s);
            } else if (s.equals("(")) {
                stack.add(s);
            } else if (s.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                sb.append(s);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        wr.write(sb.toString());
        wr.flush();
        wr.close();
        br.close();

    }

    private static int priority(String operator) {
        if (operator.equals("+") || operator.equals("-")) {
            return 1;
        } else if (operator.equals("*") || operator.equals("/")) {
            return 2;
        } else {
            return -1;
        }
    }

}

