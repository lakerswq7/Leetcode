package tree.binarysearchtree;

import java.util.Stack;

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (k-- == 1) {
                    return root.val;
                }
                root = root.right;
            }
        }
        return -1;
    }
    /* 
     * optimization
     */
    public int kthSmallest2(TreeNode root, int k) {
        int left = count(root.left);
        if (k == left + 1) {
            return root.val;
        } else if (k <= left) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - left - 1);
        }
    }
    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }
}
