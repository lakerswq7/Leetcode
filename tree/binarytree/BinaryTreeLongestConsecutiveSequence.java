package tree.binarytree;
/**
 * Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
public class BinaryTreeLongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getLongest(root, 1);
    }
    private int getLongest(TreeNode root, int n) {
        int left = 0, right = 0;
        if (root.left != null) {
            if (root.left.val == root.val + 1) {
                left = getLongest(root.left, n + 1);
            } else {
                left = getLongest(root.left, 1);
            }
        }
        if (root.right != null) {
            if (root.right.val == root.val + 1) {
                right = getLongest(root.right, n + 1);
            } else {
                right = getLongest(root.right, 1);
            }
        }
        return Math.max(n, Math.max(left, right));
    }
}
