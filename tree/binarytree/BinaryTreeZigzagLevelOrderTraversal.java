package tree.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean normalOrder = true;
        
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // ���һ���ж��Ƿ�������˳��ı������ǵĻ��������ӵ����棬����ÿһ�ζ��ӵ�ǰ��
                if (normalOrder) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
            normalOrder = !normalOrder;
        }
        return result;
    }
}
