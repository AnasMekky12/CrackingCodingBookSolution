package TreesAndGraph;

import java.util.HashMap;

public class Q12 {
    public static void main(String[] args) {
        TreeNodeQ12 root = new TreeNodeQ12(10);
        root.left = new TreeNodeQ12(5);
        root.right = new TreeNodeQ12(-3);
        root.left.left = new TreeNodeQ12(3);
        root.left.right = new TreeNodeQ12(2);
        root.right.right = new TreeNodeQ12(11);
        root.left.left.left = new TreeNodeQ12(3);
        root.left.left.right = new TreeNodeQ12(-2);
        root.left.right.right = new TreeNodeQ12(1);

        int targetSum = 8;

        System.out.println("Number of paths with sum " + targetSum + ": " + countPathsWithSum(root, targetSum));
    }

    public static int countPathsWithSum(TreeNodeQ12 root, int targetSum) {
        HashMap<Integer, Integer> runningSumMap = new HashMap<>();
        runningSumMap.put(0, 1);
        return countPathsWithSumHelper(root, targetSum, 0, runningSumMap);
    }

    private static int countPathsWithSumHelper(TreeNodeQ12 node, int targetSum, int runningSum, HashMap<Integer, Integer> runningSumMap) {
        if (node == null) {
            return 0;
        }

        runningSum += node.data;

        int sum = runningSum - targetSum;
        int totalPaths = runningSumMap.getOrDefault(sum, 0);

        runningSumMap.put(runningSum, runningSumMap.getOrDefault(runningSum, 0) + 1);

        totalPaths += countPathsWithSumHelper(node.left, targetSum, runningSum, runningSumMap);
        totalPaths += countPathsWithSumHelper(node.right, targetSum, runningSum, runningSumMap);

        runningSumMap.put(runningSum, runningSumMap.get(runningSum) - 1);

        return totalPaths;
    }
}

class TreeNodeQ12 {
    int data;
    TreeNodeQ12 left;
    TreeNodeQ12 right;

    TreeNodeQ12(int data) {
        this.data = data;
    }
}