package TreesAndGraph;

public class Q8 {
    public static void main(String[] args) {
        Q8TreeNode root = new Q8TreeNode(1);
        Q8TreeNode node2 = new Q8TreeNode(2);
        Q8TreeNode node3 = new Q8TreeNode(3);
        Q8TreeNode node4 = new Q8TreeNode(4);
        Q8TreeNode node5 = new Q8TreeNode(5);

        root.left = node2;
        root.right = node3;
        node2.parent = root;
        node3.parent = root;

        node2.left = node4;
        node2.right = node5;
        node4.parent = node2;
        node5.parent = node2;

        Q8TreeNode result = commonAncestor(node4, node5);
        if (result != null) {
            System.out.println("The first common ancestor is: " + result.data);
        } else {
            System.out.println("No common ancestor found.");
        }
    }

    public static Q8TreeNode commonAncestor(Q8TreeNode p, Q8TreeNode q) {
        int delta = depth(p) - depth(q);
        Q8TreeNode first = delta > 0 ? q : p;
        Q8TreeNode second = delta > 0 ? p : q;
        second = goUpBy(second, Math.abs(delta));

        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }

        return first == null || second == null ? null : first;
    }

    public static Q8TreeNode goUpBy(Q8TreeNode node, int delta) {
        while (delta > 0 && node != null) {
            node = node.parent;
            delta--;
        }
        return node;
    }

    public static int depth(Q8TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }
}

class Q8TreeNode {
    public int data;
    public Q8TreeNode left;
    public Q8TreeNode right;
    public Q8TreeNode parent;

    public Q8TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}