package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
/*
 * level order的方法
 */
	public class Codec {

	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        StringBuilder sb = new StringBuilder();
	        queue.offer(root);
	        while (!queue.isEmpty()) {
	            root = queue.poll();
	            sb.append(" ");
	            if (root == null) {
	                sb.append("#");
	            } else {
	                sb.append(root.val);
	                queue.offer(root.left);
	                queue.offer(root.right);
	            }
	        }
	        sb.deleteCharAt(0);
	        return sb.toString();
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        String[] vals = data.split(" ");
	        TreeNode[] nodes = new TreeNode[vals.length];
	        int nCount = 0;
	        for (int i = 0; i < vals.length; i++) {
	            if (!vals[i].equals("#")) {
	                nodes[i] = new TreeNode(Integer.parseInt(vals[i]));
	            }
	        }
	        /* 
	         * 统计之前null 节点的个数来计算他的左右孩子在哪
	         */
	        for (int i = 0; i < vals.length; i++) {
	            if (vals[i].equals("#")) {
	                nCount++;
	            } else {
	                nodes[i].left = nodes[(i - nCount) * 2 + 1];
	                nodes[i].right = nodes[(i - nCount) * 2 + 2];
	            }
	        }
	        return nodes[0];
	    }
	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));
	
	
	/*
	 * pre order 的方法, 利用递归的性质
	 */
	public class Codec2 {

	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	        if (root == null) {
	            return "#";
	        }
	        String val = String.valueOf(root.val);
	        return val + " " + serialize(root.left) + " " + serialize(root.right);
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        String[] vals = data.split(" ");
	        int[] index = new int[1];
	        return buildTree(vals, index);
	    }
	    private TreeNode buildTree(String[] vals, int[] index) {
	        if (vals[index[0]].equals("#")) {
	            index[0]++;
	            return null;
	        }
	        TreeNode root = new TreeNode(Integer.parseInt(vals[index[0]++]));
	        root.left = buildTree(vals, index);
	        root.right = buildTree(vals, index);
	        return root;
	    }
	}
}
