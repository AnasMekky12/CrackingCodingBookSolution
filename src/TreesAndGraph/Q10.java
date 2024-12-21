package TreesAndGraph;

public class Q10 {
    public static void main(String[] args) {
        BinaryTreeNode t1 = new BinaryTreeNode(3);
        t1.left = new BinaryTreeNode(4);
        t1.right = new BinaryTreeNode(5);
        t1.left.left = new BinaryTreeNode(1);
        t1.left.right = new BinaryTreeNode(2);

        BinaryTreeNode t2 = new BinaryTreeNode(4);
        t2.left = new BinaryTreeNode(1);
        t2.right = new BinaryTreeNode(2);

        boolean isSubtree = isSubtree(t1, t2);
        System.out.println("Is T2 a subtree of T1? " + isSubtree);
    }

    public static boolean isSubtree(BinaryTreeNode t1, BinaryTreeNode t2) {
        String t1PreOrder = getPreOrderString(t1);
        String t2PreOrder = getPreOrderString(t2);

        return t1PreOrder.contains(t2PreOrder);
    }

    public static String getPreOrderString(BinaryTreeNode node) {
        StringBuilder sb = new StringBuilder();
        preOrderTraversal(node, sb);
        return sb.toString();
    }

    private static void preOrderTraversal(BinaryTreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("X ");
            return;
        }
        sb.append(node.val).append(" ");
        preOrderTraversal(node.left, sb);
        preOrderTraversal(node.right, sb);
    }
}

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int val) {
        this.val = val;
    }
}