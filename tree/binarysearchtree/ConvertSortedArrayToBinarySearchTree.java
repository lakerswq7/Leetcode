package tree.binarysearchtree;

import tree.binarysearchtree.TreeNode;


public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        if ((num == null) || (num.length == 0)) {
            return null;
        }
        return convertToBST(num, 0, num.length - 1);
    }
    
    public TreeNode convertToBST(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = convertToBST(num, start, mid - 1);
        root.right = convertToBST(num, mid + 1, end);
        
        return root;
    }
}
