package org.example;

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

        int n = Integer.parseInt(br.readLine());
        StackClass stack = new StackClass();
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            boolean bool = stack.input(x);
            if (!bool) {
                flag = false;
                break;
            }
        }

        if (flag) {
            for (String s : stack.result) {
                wr.write(s + "\n");
            }
        } else {
            wr.write("NO");
        }

        wr.flush();
        wr.close();
        br.close();

    }

}

class StackClass {

    Stack<Integer> stack = new Stack<>();
    public static int cur = 0;
    public ArrayList<String> result = new ArrayList<>();

    public boolean input(int x) {
        if (stack.isEmpty()) {
            return push(x);
        } else if (stack.get(stack.size()-1) < x) {
            return push(x);
        } else if (stack.get(stack.size()-1).equals(x)) {
            stack.pop();
            result.add("-");
            return true;
        } else {
            return false;
        }

    }

    private boolean push(int x) {
        for (int i = cur+1; i <= x; i++) {
            stack.push(i);
            result.add("+");
        }
        stack.pop();
        result.add("-");
        cur = x;
        return true;
    }

}