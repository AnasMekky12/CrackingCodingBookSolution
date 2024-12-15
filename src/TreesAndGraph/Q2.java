package TreesAndGraph;

public class Q2 {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    public static TreeNode createMinimalBST(int[] sortedArray) {
        return createMinimalBSTHelper(sortedArray, 0, sortedArray.length - 1);
    }

    private static TreeNode createMinimalBSTHelper(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(array[mid]);

        node.left = createMinimalBSTHelper(array, start, mid - 1);
        node.right = createMinimalBSTHelper(array, mid + 1, end);

        return node;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = createMinimalBST(sortedArray);

        System.out.println("الشجرة الناتجة باستخدام ترتيب Pre-Order:");
        printTree(root);
    }
}

