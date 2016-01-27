package tree.binarytree;


public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // 本来应该用结果类来存两个结果：是不是平衡的， 最大深度是多少
        // 可以用 -1 来表示不是平衡的，如果不是 -1 就表示是平衡的
        if ((left == -1) || (right == -1) || (Math.abs(left - right) > 1)) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
