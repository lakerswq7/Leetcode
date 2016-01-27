package tree.binarysearchtree;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode cur;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        cur = stack.pop();
        int temp = cur.val;
        cur = cur.right;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        return temp;
    }
}
