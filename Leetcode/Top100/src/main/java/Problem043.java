import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 验证二叉搜索树
 *
 * @Author: Xiaov
 * @Date: 2024/9/4 01:35
 */
public class Problem043 {
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

    private List<Integer> inorderNums;

    public boolean isValidBST(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return true;
        inorderNums = new ArrayList<>();
        inorderTree(root);
        int pre = inorderNums.get(0);
        for (int i = 1; i < inorderNums.size(); i++) {
            if (inorderNums.get(i) <= pre) return false;
            pre = inorderNums.get(i);
        }
        inorderNums.clear();
        return true;
    }

    public void inorderTree(TreeNode root) {
        if (root == null) return;
        inorderTree(root.left);
        inorderNums.add(root.val);
        inorderTree(root.right);
    }

    public boolean isValidBSTFunc2(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return true;
        Deque<TreeNode> stack = new LinkedList<>();
        long pre = -Long.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre >= root.val) return false;
            pre = root.val;
            root = root.right;
        }
        return true;
    }

    public boolean isValidBSTFunc3(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long low, long high) {
        if (root == null) return true;
        if (root.val <= low || root.val >= high) return false;
        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
    }


}
