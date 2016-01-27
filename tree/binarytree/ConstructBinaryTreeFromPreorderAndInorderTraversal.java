package tree.binarytree;


public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if ((preorder == null) || (inorder == null)) {
            return null;
        }
        return constructTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    public TreeNode constructTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int pos = findPos(inorder, preorder[preStart], inStart, inEnd);
        root.left = constructTree(preorder, inorder, preStart + 1, preStart + pos - inStart, inStart, pos - 1);
        root.right = constructTree(preorder, inorder, preStart + pos - inStart + 1, preEnd, pos + 1, inEnd);
        return root;
    }
    public int findPos(int[] array, int target, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (array[i] == target) {
                return i;
            } 
        }
        return -1;
    }
}
