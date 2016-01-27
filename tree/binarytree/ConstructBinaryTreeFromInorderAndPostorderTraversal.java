package tree.binarytree;


public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if ((inorder == null) || (postorder == null)) {
            return null;
        }
        return constructTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    public TreeNode constructTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int pos = findPos(inorder, postorder[postEnd], inStart, inEnd);
        root.left = constructTree(inorder, postorder, inStart, pos - 1, postStart, postStart + pos - inStart - 1);
        root.right = constructTree(inorder, postorder, pos + 1, inEnd, postStart + pos - inStart, postEnd - 1);
        return root;
    }
    
    public int findPos(int[] array, int target, int start, int end) {
        for(int i = start; i <= end; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
