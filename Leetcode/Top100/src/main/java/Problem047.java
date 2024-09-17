
/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @Author: Xiaov
 * @Date: 2024/9/18 01:04
 */
public class Problem047 {
    public static class TreeNode{
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

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length -1);

    }

    private static TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        int rootOfInOrder = findRootOfInOrder(preStart, preorder, inorder, inStart, inEnd);
        if (rootOfInOrder != -1) {
            int leftSize = rootOfInOrder - inStart;
            node.left = buildTree(preorder, inorder, preStart + 1,
                    preStart + leftSize, inStart, rootOfInOrder - 1);
            node.right = buildTree(preorder, inorder, preStart + leftSize + 1, preEnd,
                    rootOfInOrder + 1, inEnd);
        }
        return node;
    }

    private static int findRootOfInOrder(int rootPreIndex, int[] preorder, int[] inorder, int inStart, int inEnd) {
        int rootVal = preorder[rootPreIndex];
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9,3,15,20,7};
        TreeNode node = buildTree(preOrder, inOrder);
        System.out.println("node = " + node.val);
    }
}
