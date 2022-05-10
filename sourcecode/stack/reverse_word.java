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
            String s = br.readLine();
            String[] s1 = s.split(" ");
            for (String s2 : s1) {
                StackClass stack = new StackClass(s2);
                wr.write(stack.reverse()+" ");
            }
            wr.write("\n");
        }

        wr.flush();
        wr.close();
        br.close();
    }

}

class StackClass{

    Stack<String> stack = new Stack<>();

    public StackClass(String str) {
        String[] strings = str.split("");
        for (String string : strings) {
            stack.push(string);
        }
    }

    public String reverse() {
        ArrayList<String> lis = new ArrayList<>();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            lis.add(stack.pop());
        }
        return String.join("", lis);
    }

}