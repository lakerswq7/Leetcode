package tree.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class SymmetricTree {
	// 非递归的方式就是按层遍历，然后检查每一层是不是对称的
	// 这里注意左右子树是null的时候也要插进去填充
	// 遇到null的时候，插入特殊值，并不再插入左右子树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    result.add(-1);
                } else {
                    result.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if (!isPalindrome(result)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    // 递归的方式就是采取以下策略
    // root1.val == root2.val
    // root1的左子树与root2的右子树对称， root1的右子树与root2的左子树对称
    public boolean isSymmetric2(TreeNode root) {
    	if (root == null) {
    		return true;
    	}
    	return isSym(root.left, root.right);
    }
    public boolean isSym(TreeNode root1, TreeNode root2) {
    	if ((root1 == null) || (root2 == null)) {
    		return (root1 == null) && (root2 == null);
    	}
    	
    	if (root1.val != root2.val) {
    		return false;
    	}
    	
    	return isSym(root1.left, root2.right) && isSym(root1.right, root2.left);
    } 
}
