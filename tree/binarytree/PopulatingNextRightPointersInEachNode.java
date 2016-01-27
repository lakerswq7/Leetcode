package tree.binarytree;

public class PopulatingNextRightPointersInEachNode {
	// 实际上就是利用有right指针这一性质来完成level order traversal
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
		// parent 代表考察的上一层的节点
		// pre 代表考察的前一个节点
		// next 代表这一次要考察的第一个节点，在最后把他赋成下一次要考察的第一个parent
		// next 更新是在前一层的末尾更新的，以判断要不要进入下一层
		TreeLinkNode parent = root;
		TreeLinkNode next = null;
		TreeLinkNode pre = null;
		// 外层循环代表不同层， 内层循环代表一层中的各个节点，每循环一下走两步，即一个parent的范围
		while ((parent != null)) {
			// pre为null代表每一层第一个节点
			if (pre == null) {
				pre = parent.left;
				next = pre;
				if (next == null) {
					return;
				}
			} else {
				pre.next = parent.left;
				pre = pre.next;
			}
			pre.next = parent.right;
			pre = pre.next;
			parent = parent.next;
			if (parent == null) {
				pre = null;
				parent = next;
			}
		}
	}
//    public void connect2(TreeLinkNode root) {
//        if (root == null) {
//            return;
//        }
//        connectHelp(root.left, root.right);
//    }
//    public void connectHelp(TreeLinkNode root1, TreeLinkNode root2) {
//        if ((root1 == null) && (root2 == null)) {
//            return;
//        }
//        root1.next = root2;
//        connectHelp(root1.left, root1.right);
//        connectHelp(root1.right, root2.left);
//        connectHelp(root2.left, root2.right);
//    }
}
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}