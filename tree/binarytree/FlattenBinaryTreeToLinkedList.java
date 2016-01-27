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
        // ���ǰ���һ���ڵ��ס��Ȼ����һ��ѭ����ʱ����һ���ڵ�����Һ��Ӷ�û���ˣ��������¸�ֵ
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
