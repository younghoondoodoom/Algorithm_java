package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StackClass stack = new StackClass();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            if (command.contains("push")) {
                String spt[] = command.split(" ");
                stack.push(Integer.parseInt(spt[1]));
            } else if (command.contains("pop")) {
                bw.write(stack.pop()+"\n");
            } else if (command.contains("size")) {
                bw.write(stack.size()+"\n");
            } else if (command.contains("empty")) {
                bw.write(stack.empty()+"\n");
            } else if (command.contains("top")) {
                bw.write(stack.top()+"\n");
            } else {
                continue;
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

}

class StackClass {

    static Stack<Integer> stack = new Stack<>();

    public void push(int n) {
        stack.add(n);
    }

    public int pop() {
        if (stack.isEmpty()){
            return -1;
        }
        return stack.pop();
    }

    public int size() {
        return stack.size();
    }

    public int empty() {
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int top() {
        if (stack.isEmpty()){
            return -1;
        }
        return stack.peek();
    }

}