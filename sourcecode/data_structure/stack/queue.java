import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        QueueClass queue = new QueueClass();

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.contains("push")) {
                String[] s = command.split(" ");
                queue.push(Integer.parseInt(s[1]));
            } else if (command.contentEquals("pop")) {
                wr.write(queue.pop() + "\n");
            } else if (command.contentEquals("size")) {
                wr.write(queue.size() + "\n");
            } else if (command.contentEquals("empty")) {
                wr.write(queue.empty() + "\n");
            } else if (command.contentEquals("front")) {
                wr.write(queue.front() + "\n");
            } else if (command.contentEquals("back")) {
                wr.write(queue.back() + "\n");
            }
        }

        wr.flush();
        wr.close();
        br.close();
    }

}

class QueueClass {

    LinkedList<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.add(x);
    }

    public Integer pop() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.poll();
    }

    public Integer size() {
        return queue.size();
    }

    public Integer empty() {
        if (queue.isEmpty()) {
            return 1;
        }
        return 0;
    }

    public Integer front() {
        Optional<Integer> first = queue.stream().findFirst();
        if (!first.isPresent()) {
            return -1;
        }
        return first.get();
    }

    public Integer back() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.getLast();
    }

}
