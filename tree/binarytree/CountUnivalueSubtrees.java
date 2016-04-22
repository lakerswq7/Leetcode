package tree.binarytree;
/**
 * Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
return 4.
 */
public class CountUnivalueSubtrees {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        allSameValue(root, 0);
        return count;
    }
    private boolean allSameValue(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        boolean left = allSameValue(root.left, root.val);
        boolean right = allSameValue(root.right, root.val);
        if (left && right) {
            count++;
            if (root.val == val) {
                return true;
            }
        }
        return false;
    }
}
