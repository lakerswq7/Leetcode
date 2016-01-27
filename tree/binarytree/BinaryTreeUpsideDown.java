package tree.binarytree;

public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode right = null;
        TreeNode left = null;
        while (cur != null) {
            left = cur.left;
            cur.left = right;
            right = cur.right;
            cur.right = pre;
            pre = cur;
            cur = left;
        }
        return pre;
   }
}
