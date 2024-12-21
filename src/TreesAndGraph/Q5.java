package TreesAndGraph;

public class Q5 {
    public static void main(String[] args) {
        TreeN root = new TreeN(2);
        root.left = new TreeN(1);
        root.right = new TreeN(3);

        boolean result = isValidBST(root);

        System.out.println("Is the tree a valid BST? " + result);
    }

    public static boolean isValidBST(TreeN root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeN node, long low, long high) {
        if (node == null) {
            return true;
        }

        if (node.val <= low || node.val >= high) {
            return false;
        }

        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
}

class TreeN {
    int val;
    TreeN left;
    TreeN right;

    TreeN(int val) {
        this.val = val;
    }
}