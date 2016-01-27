package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;


public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p, q);
    }
    public boolean isSame(TreeNode root1, TreeNode root2) {
        if ((root1 == null) || (root2 == null)) {
            return (root1 == null) && (root2 == null);
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
     public boolean isSameTree2(TreeNode p, TreeNode q) {
         Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
         Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
         queue1.offer(p);
         queue2.offer(q);
         while ((!queue1.isEmpty()) && (!queue2.isEmpty())) {
             TreeNode node1 = queue1.poll();
             TreeNode node2 = queue2.poll();
             if ((node1 == null) && (node2 == null)) {
                 continue;
             }
             if ((node1 == null) || (node2 == null)) {
                 return false;
             }
             if (node1.val != node2.val) {
                 return false;
             }
             queue1.offer(node1.left);
             queue1.offer(node1.right);
             queue2.offer(node2.left);
             queue2.offer(node2.right);
         }
         if ((!queue1.isEmpty()) || (!queue2.isEmpty())) {
             return false;
         }
         return true;
     }
}
