package tree.binarysearchtree;
/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        double diff = Double.MAX_VALUE;
        int val = 0;
        while (root != null) {
            double d = Math.abs(target - root.val);
            if (d < diff) {
                diff = d;
                val = root.val;
            }
            if (root.val <= target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return val;
    }
}
