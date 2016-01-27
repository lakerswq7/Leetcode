package tree.binarysearchtree;

import java.util.Stack;

// 交换的情况有两种可能: 12 34 -> 42 31 或者 12 -> 21
// 第一种可能只能是第一个数和最后一个数交换，所以需要记住第一个数。 123 -> 321 和这种情况实际上是一样的
// 第二种可能需要遍历完所有以后，看是否没有第二次逆序了，如果是这样就交换前两个数，所以需要前两个数都记住
public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode last = new TreeNode(Integer.MIN_VALUE);
        TreeNode first = null, second = null;
        
        while ((!stack.empty()) || (root != null)) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.val < last.val) {
                    if (first == null) {
                        first = last;
                        second = root;
                    } else {
                        swap(first, root);
                        return;
                    }
                }
                last = root;
                root = root.right;
            }
        }
        swap(first, second);
    }
    public void swap(TreeNode node1, TreeNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}