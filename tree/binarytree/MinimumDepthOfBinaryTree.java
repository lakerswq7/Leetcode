package tree.binarytree;


public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMinDepth(root);
    }
    public int getMinDepth(TreeNode root) {
    	// 因为null不能取，不是边界，所以赋为MAX_VALUE，让它永远被比下去
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        // 真正边界是叶子节点，返回1
        if ((root.left == null) && (root.right == null)) {
            return 1;
        }
        return Math.min(getMinDepth(root.left), getMinDepth(root.right)) + 1;
    }
}
