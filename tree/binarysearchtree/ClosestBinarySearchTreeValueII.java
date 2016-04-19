package tree.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?

Hint:

Consider implement these two helper functions:
getPredecessor(N), which returns the next smaller node to N.
getSuccessor(N), which returns the next larger node to N.
Try to assume that each node has a parent pointer, it makes the problem much easier.
Without parent pointer we just need to keep track of the path from the root to the current node using a stack.
You would need two stacks to track the path in finding predecessor and successor node separately.
 */
public class ClosestBinarySearchTreeValueII {
	/*
	 * O(n)的解法，就是中序遍历
	 */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> rst = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (rst.size() < k) {
                    rst.add(root.val);
                } else {
                    if (Math.abs(rst.get(0) - target) > Math.abs(root.val - target)) {
                        rst.remove(0);
                        rst.add(root.val);
                    } else {
                        break;
                    }
                }
                root = root.right;
            }
        }
        return rst;
    }
    /*
     * O(klogn)的解法，思想就是通过BST的特性先找到紧邻的两个值，然后分别通过
     * 比较，小的部分和大的部分，取出k个值
     */
    public List<Integer> closestKValues2(TreeNode root, double target, int k) {
        Stack<TreeNode> pred = new Stack<TreeNode>();
        Stack<TreeNode> succ = new Stack<TreeNode>();
        List<Integer> rst = new ArrayList<Integer>();
        while (root != null) {
            if (root.val < target) {
                pred.push(root);
                root = root.right;
            } else {
                succ.push(root);
                root = root.left;
            }
        }
        while (k > 0) {
            if (pred.empty() && succ.empty()) {
                break;
            } else if (pred.empty()) {
                rst.add(getSuccessor(succ));
            } else if (succ.empty()) {
                rst.add(getPredecessor(pred));
            } else if (Math.abs(pred.peek().val - target) < Math.abs(succ.peek().val - target)) {
                rst.add(getPredecessor(pred));
            } else {
                rst.add(getSuccessor(succ));
            }
            k--;
        }
        return rst;
    }
    private int getPredecessor(Stack<TreeNode> pred) {
        TreeNode cur = pred.pop();
        TreeNode c = cur.left;
        while (c != null) {
            pred.push(c);
            c = c.right;
        }
        return cur.val;
    }
    private int getSuccessor(Stack<TreeNode> succ) {
        TreeNode cur = succ.pop();
        TreeNode c = cur.right;
        while (c != null) {
            succ.push(c);
            c = c.left;
        }
        return cur.val;
    }
}
