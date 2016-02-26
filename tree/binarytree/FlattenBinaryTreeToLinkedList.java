package tree.binarytree;

import java.util.Stack;


public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        } 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode last = new TreeNode(0);
        // 就是把上一个节点记住，然后下一次循环的时候，上一个节点的左右孩子都没用了，可以重新赋值
        while (!stack.empty()) {
            root = stack.pop();
            last.right = root;
            last.left = null;
            last = root;
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
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
