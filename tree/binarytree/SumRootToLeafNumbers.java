package tree.binarytree;

public class SumRootToLeafNumbers {
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return sum;
        }
        sumNumber(root, 0);
        return sum;
    }
    private void sumNumber(TreeNode root, int pre) {
        int cur = pre * 10 + root.val;
        if ((root.left == null) && (root.right == null)) {
            sum += cur;
            return;
        }
        if (root.left != null) {
            sumNumber(root.left, cur);
        }
        if (root.right != null) {
            sumNumber(root.right, cur);
        }
    }
}
