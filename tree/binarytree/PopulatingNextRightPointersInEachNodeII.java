package tree.binarytree;

public class PopulatingNextRightPointersInEachNodeII {
	// 这个问题复杂之处在于，你不知道下一层的第一个有效地节点在哪，在pre 为null的时候，找到第一个节点
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode parent = root;
		TreeLinkNode next = null;
		TreeLinkNode pre = null;

		// next在这里代表下一层的时候，从哪个parent开始
		while (parent != null) {
			if (parent.left != null) {
				if (pre == null) {
					pre = parent.left;
					next = parent.left;

				} else {
					pre.next = parent.left;
					pre = pre.next;
				}
			}
			if (parent.right != null) {
				if (pre == null) {
					pre = parent.right;
					next = parent.right;
				} else {
					pre.next = parent.right;
					pre = pre.next;
				}
			}
			parent = parent.next;
			if (parent == null) {
				parent = next;
				pre = null;
				next = null;
			}
		}
	}
//	public void connect2(TreeLinkNode root) {
//		TreeLinkNode parent = root;
//		TreeLinkNode first = new TreeLinkNode(0);
//		TreeLinkNode child = first;
//		while (parent != null) {
//		    if (parent.left != null) {
//		        child.next = parent.left;
//		        child = child.next;
//		    }
//		    if (parent.right != null) {
//		        child.next = parent.right;
//		        child = child.next;
//		    }
//		    parent = parent.next;
//		    if (parent == null) {
//		        parent = first.next;
//		        child = first;
//		        first.next = null;
//		    }
//		}
//	}
}
