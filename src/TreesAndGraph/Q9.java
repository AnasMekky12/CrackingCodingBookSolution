package TreesAndGraph;

import java.util.*;

public class Q9 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        List<List<Integer>> result = allSequences(root);
        System.out.println("Possible BST sequences:");
        for (List<Integer> seq : result) {
            System.out.println(seq);
        }
    }

    public static List<List<Integer>> allSequences(TreeNode node) {
        List<List<Integer>> result = new ArrayList<>();

        if (node == null) {
            result.add(new ArrayList<>());
            return result;
        }

        List<Integer> prefix = new ArrayList<>();
        prefix.add(node.data);

        List<List<Integer>> leftSeq = allSequences(node.left);
        List<List<Integer>> rightSeq = allSequences(node.right);

        for (List<Integer> left : leftSeq) {
            for (List<Integer> right : rightSeq) {
                List<List<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }

        return result;
    }

    public static void weaveLists(List<Integer> first, List<Integer> second,
                                  List<List<Integer>> results, List<Integer> prefix) {
        if (first.isEmpty() || second.isEmpty()) {
            List<Integer> result = new ArrayList<>(prefix);
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        int headFirst = first.remove(0);
        prefix.add(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.remove(prefix.size() - 1);
        first.add(0, headFirst);

        int headSecond = second.remove(0);
        prefix.add(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.remove(prefix.size() - 1);
        second.add(0, headSecond);
    }

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}