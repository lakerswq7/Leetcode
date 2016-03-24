package tree.binarytree;

public class CountCompleteTreeNode {
    public int countNodes(TreeNode root) {
        int h = height(root);
        if (h == -1) {
            return 0;
        }
        return height(root.right) == h - 1 ? (1 << h) + countNodes(root.right) : (1 << (h - 1)) + countNodes(root.left);
    }
    private int height(TreeNode root) {
        int height = -1;
        while (root != null) {
            root = root.left;
            height++;
        }
        return height;
    }
}
