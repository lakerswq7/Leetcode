package tree.binarytree;


public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMinDepth(root);
    }
    public int getMinDepth(TreeNode root) {
    	// ��Ϊnull����ȡ�����Ǳ߽磬���Ը�ΪMAX_VALUE��������Զ������ȥ
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        // �����߽���Ҷ�ӽڵ㣬����1
        if ((root.left == null) && (root.right == null)) {
            return 1;
        }
        return Math.min(getMinDepth(root.left), getMinDepth(root.right)) + 1;
    }
}
