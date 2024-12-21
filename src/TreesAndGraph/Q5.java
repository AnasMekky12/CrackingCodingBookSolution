package TreesAndGraph;

public class Q5 {
    public static void main(String[] args) {
        // إنشاء شجرة للاختبار
        TreeN root = new TreeN(2);
        root.left = new TreeN(1);
        root.right = new TreeN(3);

        // التحقق من إذا كانت الشجرة عبارة عن BST
        boolean result = isValidBST(root);

        // طباعة النتيجة
        System.out.println("Is the tree a valid BST? " + result);
    }

    // دالة للتحقق من إذا كانت الشجرة عبارة عن BST
    public static boolean isValidBST(TreeN root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // دالة مساعدة للتحقق باستخدام النطاقات
    private static boolean validate(TreeN node, long low, long high) {
        // إذا وصلت إلى عقدة فارغة، تعتبر صالحة
        if (node == null) {
            return true;
        }

        // التحقق من أن قيمة العقدة الحالية تقع ضمن النطاق المحدد
        if (node.val <= low || node.val >= high) {
            return false;
        }

        // التحقق من الشجرة اليسرى واليمنى مع تحديث النطاقات
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
}

// تعريف عقدة الشجرة
class TreeN {
    int val;
    TreeN left;
    TreeN right;

    TreeN(int val) {
        this.val = val;
    }
}