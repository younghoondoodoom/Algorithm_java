
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StackClass stack = new StackClass();
            String s = br.readLine();
            wr.write(stack.input(s) + "\n");
        }

        wr.flush();
        wr.close();
        br.close();

    }

}

class StackClass {

    Stack<String> stack = new Stack<>();

    public String input(String s) {
        String[] list = s.split("");
        for (int i = 0; i < list.length; i++) {
            if (list[i].contentEquals("(")) {
                stack.push("(");
            } else if (list[i].contentEquals(")")) {
                if (stack.empty()) {
                    return "NO";
                } else{
                    stack.pop();
                }
            }
        }
        if (stack.empty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

}