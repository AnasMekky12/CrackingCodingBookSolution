package TreesAndGraph;

public class Q10 {
    public static void main(String[] args) {
        // إنشاء شجرتين
        BinaryTreeNode t1 = new BinaryTreeNode(3);
        t1.left = new BinaryTreeNode(4);
        t1.right = new BinaryTreeNode(5);
        t1.left.left = new BinaryTreeNode(1);
        t1.left.right = new BinaryTreeNode(2);

        BinaryTreeNode t2 = new BinaryTreeNode(4);
        t2.left = new BinaryTreeNode(1);
        t2.right = new BinaryTreeNode(2);

        // التحقق مما إذا كانت T2 شجرة فرعية من T1
        boolean isSubtree = isSubtree(t1, t2);
        System.out.println("Is T2 a subtree of T1? " + isSubtree);
    }

    // التحقق إذا كانت T2 شجرة فرعية من T1
    public static boolean isSubtree(BinaryTreeNode t1, BinaryTreeNode t2) {
        // الحصول على التمثيل النصي لكل من T1 و T2
        String t1PreOrder = getPreOrderString(t1);
        String t2PreOrder = getPreOrderString(t2);

        // التحقق إذا كان تمثيل T2 موجودًا كجزء من تمثيل T1
        return t1PreOrder.contains(t2PreOrder);
    }

    // طريقة لإجراء Pre-order Traversal مع تسجيل العقد الفارغة
    public static String getPreOrderString(BinaryTreeNode node) {
        StringBuilder sb = new StringBuilder();
        preOrderTraversal(node, sb);
        return sb.toString();
    }

    private static void preOrderTraversal(BinaryTreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("X "); // إضافة علامة مميزة للعقد الفارغة
            return;
        }
        sb.append(node.val).append(" "); // إضافة قيمة العقدة الحالية
        preOrderTraversal(node.left, sb); // الانتقال إلى العقدة اليسرى
        preOrderTraversal(node.right, sb); // الانتقال إلى العقدة اليمنى
    }
}

// تعريف شجرة ثنائية مع التسمية الجديدة
class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int val) {
        this.val = val;
    }
}