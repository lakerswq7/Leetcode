package tree.binarysearchtree;

import java.util.Stack;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int last = Integer.MIN_VALUE;
        
        while ((!stack.empty()) || (root != null)) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                // 这里给的定义是严格大于或者小于，没有等于
                if (root.val <= last) {
                    return false;
                }
                last = root.val;
                root = root.right;
            }
        }
        return true;
    }
}
