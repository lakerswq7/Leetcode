package tree.binarytree;

public class PopulatingNextRightPointersInEachNode {
	// ʵ���Ͼ���������rightָ����һ���������level order traversal
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
		// parent ���������һ��Ľڵ�
		// pre �������ǰһ���ڵ�
		// next ������һ��Ҫ����ĵ�һ���ڵ㣬��������������һ��Ҫ����ĵ�һ��parent
		// next ��������ǰһ���ĩβ���µģ����ж�Ҫ��Ҫ������һ��
		TreeLinkNode parent = root;
		TreeLinkNode next = null;
		TreeLinkNode pre = null;
		// ���ѭ������ͬ�㣬 �ڲ�ѭ������һ���еĸ����ڵ㣬ÿѭ��һ������������һ��parent�ķ�Χ
		while ((parent != null)) {
			// preΪnull����ÿһ���һ���ڵ�
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