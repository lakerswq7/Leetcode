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
        // ����Ӧ���ý������������������ǲ���ƽ��ģ� �������Ƕ���
        // ������ -1 ����ʾ����ƽ��ģ�������� -1 �ͱ�ʾ��ƽ���
        if ((left == -1) || (right == -1) || (Math.abs(left - right) > 1)) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
