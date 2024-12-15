package TreesAndGraph;

import java.util.*;

class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class LinkedListNode {
    int value;
    LinkedListNode next;

    LinkedListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class Q3 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<LinkedListNode> lists = createLevelLinkedList(root);

        printLevelLinkedLists(lists);
    }

    public static List<LinkedListNode> createLevelLinkedList(TreeNode root) {
        List<LinkedListNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedListNode levelHead = null;
            LinkedListNode current = null;

            // معالجة العقد في المستوى الحالي
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // إضافة العقدة إلى القائمة المرتبطة
                LinkedListNode newNode = new LinkedListNode(node.value);
                if (levelHead == null) {
                    levelHead = newNode;
                } else {
                    current.next = newNode;
                }
                current = newNode;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add(levelHead);
        }

        return result;
    }

    public static void printLevelLinkedLists(List<LinkedListNode> lists) {
        int level = 0;
        for (LinkedListNode head : lists) {
            System.out.print("Level " + level + ": ");
            while (head != null) {
                System.out.print(head.value + " -> ");
                head = head.next;
            }
            System.out.println("null");
            level++;
        }
    }
}

