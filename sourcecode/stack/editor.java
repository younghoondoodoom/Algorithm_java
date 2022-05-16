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

        String input = br.readLine();
        Editor editor = new Editor(input.split(""));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.contains("P")) {
                String[] comm_lis = command.split(" ");
                editor.P(comm_lis[1]);
            } else if (command.contentEquals("L")) {
                editor.L();
            } else if (command.contentEquals("D")) {
                editor.D();
            } else if (command.contentEquals("B")) {
                editor.B();
            }
        }

        wr.write(editor.getResult());

        br.close();
        wr.flush();
        wr.close();
    }

}

class Editor {

    Stack leftStack = new Stack<>();
    Stack rightStack = new Stack<>();

    public String getResult() {
        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        return sb.toString();
    }

    public Editor(String[] input) {
        for (String s : input) {
            leftStack.push(s);
        }
    }

    public void L() {
        if (leftStack.isEmpty()) {
            return;
        }
        rightStack.push(leftStack.pop());
    }

    public void D() {
        if (rightStack.isEmpty()) {
            return;
        }
        leftStack.push(rightStack.pop());
    }

    public void B() {
        if (leftStack.isEmpty()) {
            return;
        }
        leftStack.pop();
    }

    public void P(String x) {
        leftStack.push(x);
    }

}