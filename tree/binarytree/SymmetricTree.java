package tree.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class SymmetricTree {
	// �ǵݹ�ķ�ʽ���ǰ��������Ȼ����ÿһ���ǲ��ǶԳƵ�
	// ����ע������������null��ʱ��ҲҪ���ȥ���
	// ����null��ʱ�򣬲�������ֵ�������ٲ�����������
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
    
    // �ݹ�ķ�ʽ���ǲ�ȡ���²���
    // root1.val == root2.val
    // root1����������root2���������Գƣ� root1����������root2���������Գ�
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
