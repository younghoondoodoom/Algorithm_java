import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        HashMap<Character, Double> map = new HashMap<>();

        StackClass stack = new StackClass();

        for (char x : input) {
            if (isAlpha(x)) {
                double y;
                if (map.containsKey(x)) {
                    y = map.get(x);
                } else {
                    y = Double.parseDouble(br.readLine());
                    map.put(x, y);
                }
                stack.push(y);
            } else {
                if (x == '*') {
                    stack.multi();
                } else if (x == '/') {
                    stack.divide();
                } else if (x == '-') {
                    stack.minus();
                } else if (x == '+') {
                    stack.plus();
                }
            }
        }

        double result = stack.getResult();
        wr.write(String.format("%.2f", result));

        wr.flush();
        wr.close();
        br.close();

    }

    public static boolean isAlpha(char x) {
        if (x >= 'A' && x <= 'Z') {
            return true;
        }
        return false;
    }
}

class StackClass {

    Stack<Double> stack = new Stack<>();

    public double getResult() {
        if (stack.size() != 1) {
            throw new IllegalStateException();
        } else {
            return stack.pop();
        }
    }

    public void push(double x) {
        stack.push(x);
    }

    public void multi() {
        double x = stack.pop() * stack.pop();
        stack.push(x);
    }

    public void divide() {
        double first = stack.pop();
        double second = stack.pop();
        double x = second / first;
        stack.push(x);
    }

    public void minus() {
        double first = stack.pop();
        double second = stack.pop();
        double x = second - first;
        stack.push(x);
    }

    public void plus() {
        double x = stack.pop() + stack.pop();
        stack.push(x);
    }

}

