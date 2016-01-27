package tree.binarysearchtree;

import java.util.Stack;

// ��������������ֿ���: 12 34 -> 42 31 ���� 12 -> 21
// ��һ�ֿ���ֻ���ǵ�һ���������һ����������������Ҫ��ס��һ������ 123 -> 321 ���������ʵ������һ����
// �ڶ��ֿ�����Ҫ�����������Ժ󣬿��Ƿ�û�еڶ��������ˣ�����������ͽ���ǰ��������������Ҫǰ����������ס
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