package TreesAndGraph;

import java.util.Random;

public class Q11 {
    public static void main(String[] args) {
        // Create a new tree
        Tree tree = new Tree();

        // Insert nodes into the tree
        tree.insertInOrder(20);
        tree.insertInOrder(10);
        tree.insertInOrder(30);
        tree.insertInOrder(5);
        tree.insertInOrder(15);
        tree.insertInOrder(25);
        tree.insertInOrder(35);

        // Test the getRandomNode() method
        System.out.println("Random Node Data: " + tree.getRandomNode().data());
    }
}

// Node Class
class Node {
    private int data;
    public Node left;
    public Node right;
    private int size = 0;

    public Node(int d) {
        data = d;
        size = 1;
    }

    // Returns a random node from the subtree
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

    // Inserts a new value into the tree
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

    // Returns the size of the subtree
    public int size() {
        return size;
    }

    // Returns the data of the node
    public int data() {
        return data;
    }
}

// Tree Class
class Tree {
    private Node root = null;

    // Inserts a new value into the tree
    public void insertInOrder(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root.insertInOrder(value);
        }
    }

    // Returns a random node from the tree
    public Node getRandomNode() {
        if (root == null) return null;

        Random random = new Random();
        int i = random.nextInt(root.size());
        return root.getRandomNode();
    }
}