package tree.binarysearchtree;
/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
Here's an example:
    10
    / \
   5  15
  / \   \ 
 1   8   7
The Largest BST Subtree in this case is the highlighted one. 
The return value is the subtree's size, which is 3.
Hint:

You can recursively use algorithm similar to 98. Validate Binary Search Tree at each node of the tree, which will result in O(nlogn) time complexity.
Follow up:
Can you figure out ways to solve it with O(n) time complexity?
 */
public class LargestBSTSubtree {
    public int largestBSTSubtree(TreeNode root) {
        return traverse(root).largest;
    }
    private Result traverse(TreeNode root) {
        if (root == null) {
            return new Result();
        }
        Result left = traverse(root.left);
        Result right = traverse(root.right);
        Result cur = new Result();
        cur.isBST = left.isBST && right.isBST && (root.left == null || left.max < root.val) && (root.right == null || right.min > root.val);
        if (cur.isBST) {
            cur.max = root.right == null ? root.val : right.max;
            cur.min = root.left == null ? root.val : left.min;
            cur.largest = left.largest + right.largest + 1;
        } else {
            cur.largest = Math.max(left.largest, right.largest);
        }
        return cur;
    }
    class Result {
        int max, min;
        boolean isBST;
        int largest;
        Result() {
            this.max = 0;
            this.min = 0;
            this.isBST = true;
            this.largest = 0;
        }
    }
}
