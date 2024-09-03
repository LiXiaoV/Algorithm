import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树展开为链表
 *
 * @Author: Xiaov
 * @Date: 2024/9/4 03:54
 */
public class Problem046 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                list.add(root);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }

        TreeNode pre = new TreeNode(-1);
        for (TreeNode treeNode : list) {
            pre.left = null;
            pre.right = treeNode;
            pre = treeNode;
        }
    }

    public void flattenFunc2(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = new TreeNode(-1);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            prev.left = null;
            prev.right = node;
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            prev = node;
        }
    }

    public void flattenFunc3(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                TreeNode next = node.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = node.right;
                node.left = null;
                node.right = next;
            }
            node = node.right;
        }
    }
}
