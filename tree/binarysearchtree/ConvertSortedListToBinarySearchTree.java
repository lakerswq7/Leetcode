package tree.binarysearchtree;

import tree.binarysearchtree.TreeNode;


public class ConvertSortedListToBinarySearchTree {
	// 以DFS的特性，每到root的时候就往前走一个，实际上的调用顺序就是按照一个一个往前走的顺序
	private ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int len = 0;
        cur = head;
        while (head != null) {
            len++;
            head = head.next;
        }
        return constructBST(len);
    }
    
    private TreeNode constructBST(int len) {
        if (len == 0) {
            return null;
        }
        TreeNode left = constructBST(len / 2);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = constructBST(len - 1 - len / 2);
        root.left = left;
        root.right = right;
        return root;
    }
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; next = null; }
}