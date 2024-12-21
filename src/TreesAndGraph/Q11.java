package TreesAndGraph;

import java.util.Random;

public class Q11 {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insertInOrder(20);
        tree.insertInOrder(10);
        tree.insertInOrder(30);
        tree.insertInOrder(5);
        tree.insertInOrder(15);
        tree.insertInOrder(25);
        tree.insertInOrder(35);

        System.out.println("Random Node Data: " + tree.getRandomNode().data());
    }
}

class Node {
    private int data;
    public Node left;
    public Node right;
    private int size = 0;

    public Node(int d) {
        data = d;
        size = 1;
    }

    public Node getRandomNode() {
        int leftSize = left == null ? 0 : left.size();
        Random random = new Random();
        int index = random.nextInt(size);

        if (index < leftSize) {
            return left.getRandomNode();
        } else if (index == leftSize) {
            return this;
        } else {
            return right.getRandomNode();
        }
    }

    public void insertInOrder(int d) {
        if (d <= data) {
            if (left == null) {
                left = new Node(d);
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                right = new Node(d);
            } else {
                right.insertInOrder(d);
            }
        }
        size++;
    }

    public int size() {
        return size;
    }

    public int data() {
        return data;
    }
}

class Tree {
    private Node root = null;

    public void insertInOrder(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root.insertInOrder(value);
        }
    }

    public Node getRandomNode() {
        if (root == null) return null;

        Random random = new Random();
        int i = random.nextInt(root.size());
        return root.getRandomNode();
    }
}