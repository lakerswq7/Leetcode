package tree.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        TreeNode node;
        stack.push(root);
        TreeNode pre = root;
        while (!stack.empty()) {
            node = stack.pop();
            if (((node.left == null) && (node.right == null))
            		|| (pre == node.left) || (pre == node.right)){
                result.add(node.val);
                pre = node;
            } else {
                stack.push(node);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            
        }
        return result;
    }
}
