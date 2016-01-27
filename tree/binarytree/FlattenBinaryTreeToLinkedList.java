package tree.binarytree;

import java.util.Stack;


public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode last = new TreeNode(0);
        TreeNode cur;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        // 就是把上一个节点记住，然后下一次循环的时候，上一个节点的左右孩子都没用了，可以重新赋值
        while(!stack.empty()) {
            cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            last.right = cur;
            last.left = null;
            last = cur;
        }
    }
//    private TreeNode last = null;
//    public void flatten2(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        TreeNode right = root.right;
//        if (last == null) {
//            last = root;
//        } else {
//            last.left = null;
//            last.right = root;
//            last = root;
//        }
//        flatten(root.left);
//        flatten(right);
//    }
}
