package tree.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        TreeNode node = root;
        while ((!stack.empty()) || (node != null)) {
            if (node !=  null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }
}
