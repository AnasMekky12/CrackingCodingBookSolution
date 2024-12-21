package TreesAndGraph;

import java.util.HashMap;

public class Q12 {
    public static void main(String[] args) {
        // بناء شجرة ثنائية كمثال
        TreeNodeQ12 root = new TreeNodeQ12(10);
        root.left = new TreeNodeQ12(5);
        root.right = new TreeNodeQ12(-3);
        root.left.left = new TreeNodeQ12(3);
        root.left.right = new TreeNodeQ12(2);
        root.right.right = new TreeNodeQ12(11);
        root.left.left.left = new TreeNodeQ12(3);
        root.left.left.right = new TreeNodeQ12(-2);
        root.left.right.right = new TreeNodeQ12(1);

        // القيمة المستهدفة
        int targetSum = 8;

        // طباعة النتيجة
        System.out.println("Number of paths with sum " + targetSum + ": " + countPathsWithSum(root, targetSum));
    }

    // الدالة الرئيسية التي تُحسب عدد المسارات مع مجموع معين
    public static int countPathsWithSum(TreeNodeQ12 root, int targetSum) {
        // إنشاء خريطة تجزئة لتتبع المجموع الجاري وعدد مرات ظهوره
        HashMap<Integer, Integer> runningSumMap = new HashMap<>();
        runningSumMap.put(0, 1); // لمجموع ابتدائي 0، نحتاجه لاحتساب المسارات التي تبدأ من الجذر
        return countPathsWithSumHelper(root, targetSum, 0, runningSumMap);
    }

    // الدالة المساعدة لحساب عدد المسارات
    private static int countPathsWithSumHelper(TreeNodeQ12 node, int targetSum, int runningSum, HashMap<Integer, Integer> runningSumMap) {
        if (node == null) {
            return 0;
        }

        // تحديث المجموع الجاري
        runningSum += node.data;

        // حساب عدد المسارات التي تحقق المجموع المستهدف
        int sum = runningSum - targetSum;
        int totalPaths = runningSumMap.getOrDefault(sum, 0);

        // تحديث الخريطة بإضافة المجموع الجاري
        runningSumMap.put(runningSum, runningSumMap.getOrDefault(runningSum, 0) + 1);

        // حساب المسارات في الجانبين الأيسر والأيمن
        totalPaths += countPathsWithSumHelper(node.left, targetSum, runningSum, runningSumMap);
        totalPaths += countPathsWithSumHelper(node.right, targetSum, runningSum, runningSumMap);

        // التراجع (Backtrack): إزالة المجموع الجاري عند العودة من العقدة
        runningSumMap.put(runningSum, runningSumMap.get(runningSum) - 1);

        return totalPaths;
    }
}

// تعريف كائن العقدة لشجرة ثنائية
class TreeNodeQ12 {
    int data;
    TreeNodeQ12 left;
    TreeNodeQ12 right;

    TreeNodeQ12(int data) {
        this.data = data;
    }
}