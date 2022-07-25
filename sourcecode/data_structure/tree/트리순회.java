package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class Node {
    String data;
    Node left;
    Node right;

    public Node(String data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

}

class Tree {
    Node head;

    public Tree() {}

    public Node findNode(Node node, String data) {
        if (node == null) {
            return null;
        }

        if (node.data.equals(data)) {
            return node;
        }

        Node left = findNode(node.left, data);
        Node right = findNode(node.right, data);

        if (left != null && left.data.equals(data)) {
            return left;
        } else if (right != null && right.data.equals(data)) {
            return right;
        }

        return null;
    }

    public void addNode(String parent, String left, String right) {
        Node parentNode;
        if (head == null) {
            head = new Node(parent, null, null);
            parentNode = head;
        } else {
            parentNode = findNode(head, parent);
        }

        if (!left.equals(".")) {
            parentNode.left = new Node(left, null, null);
        }

        if (!right.equals(".")) {
            parentNode.right = new Node(right, null, null);
        }
    }

    public void preOrder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        sb.append(node.data);
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    public void inOrder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        inOrder(node.left, sb);
        sb.append(node.data);
        inOrder(node.right, sb);
    }

    public void postOrder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        postOrder(node.left, sb);
        postOrder(node.right, sb);
        sb.append(node.data);
    }


}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        Tree tree = new Tree();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            tree.addNode(inputs[0], inputs[1], inputs[2]);
        }

        StringBuilder preSb = new StringBuilder();
        tree.preOrder(tree.head, preSb);

        StringBuilder inSb = new StringBuilder();
        tree.inOrder(tree.head, inSb);

        StringBuilder postSb = new StringBuilder();
        tree.postOrder(tree.head, postSb);

        wr.write(preSb.toString() + "\n");
        wr.write(inSb.toString() + "\n");
        wr.write(postSb.toString());
        wr.flush();
        wr.close();
        br.close();
    }

}

