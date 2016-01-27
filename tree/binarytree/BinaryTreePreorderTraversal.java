package tree.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node;
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.empty()) {
            node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
//    public List<Integer> preorderTraversalII(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        List<Integer> result = new ArrayList<Integer>();
//        while ((root != null) || (!stack.empty())) {
//            if (root != null) {
//                result.add(root.val);
//                stack.push(root);
//                root = root.left;
//            } else {
//                root = stack.pop().right;
//            }
//        }
//        return result;
//    }
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
