import java.io.BufferedReader;
import java.io.BuffredWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        DequeClass deque = new DequeClass();

        for (int i = 0; i < n; i++) {
            String comm = br.readLine();
            if (comm.contains("push_front")) {
                int x = Integer.parseInt(comm.split(" ")[1]);
                deque.push_front(x);
            } else if (comm.contains("push_back")) {
                int x = Integer.parseInt(comm.split(" ")[1]);
                deque.push_back(x);
            } else if (comm.contains("pop_front")) {
                wr.write(deque.pop_front() + "\n");
            } else if (comm.contains("pop_back")) {
                wr.write(deque.pop_back() + "\n");
            } else if (comm.contains("size")) {
                wr.write(deque.size() + "\n");
            } else if (comm.contains("empty")) {
                wr.write(deque.empty() + "\n");
            } else if (comm.contains("front")) {
                wr.write(deque.front() + "\n");
            } else if (comm.contains("back")) {
                wr.write(deque.back() + "\n");
            }
        }

        br.close();
        wr.flush();
        wr.close();

    }

}

class DequeClass {

    Deque<Integer> deque = new ArrayDeque<>();

    public void push_front(int x) {
        deque.addFirst(x);
    }

    public void push_back(int x) {
        deque.addLast(x);
    }

    public int pop_front() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.pollFirst();
    }

    public int pop_back() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.pollLast();
    }

    public int size() {
        return deque.size();
    }

    public int empty() {
        if (deque.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int front() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.getFirst();
    }

    public int back() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.getLast();
    }


}
