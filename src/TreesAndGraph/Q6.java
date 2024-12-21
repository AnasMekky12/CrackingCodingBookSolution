package TreesAndGraph;

class TreeNodeQ6 {
    int value;
    TreeNodeQ6 left, right, parent;

    TreeNodeQ6(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

public class Q6 {

    public static void main(String[] args) {
        TreeNodeQ6 root = new TreeNodeQ6(20);
        root.left = new TreeNodeQ6(10);
        root.right = new TreeNodeQ6(30);
        root.left.parent = root;
        root.right.parent = root;
        root.left.left = new TreeNodeQ6(5);
        root.left.right = new TreeNodeQ6(15);
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;

        TreeNodeQ6 node = root.left.right;
        TreeNodeQ6 successor = inorderSucc(node);

        if (successor != null) {
            System.out.println("The in-order successor of " + node.value + " is: " + successor.value);
        } else {
            System.out.println("The node " + node.value + " has no in-order successor.");
        }
    }


    public static TreeNodeQ6 inorderSucc(TreeNodeQ6 n) {
        if (n == null) return null;

        if (n.right != null) {
            return leftMostChild(n.right);
        } else {
            TreeNodeQ6 q = n;
            TreeNodeQ6 x = q.parent;

            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }


    public static TreeNodeQ6 leftMostChild(TreeNodeQ6 n) {
        if (n == null) {
            return null;
        }
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }
}