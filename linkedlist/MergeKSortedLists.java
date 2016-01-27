package linkedlist;

import java.util.LinkedList;
import java.util.List;

public class MergeKSortedLists {
    public ListNode mergeKLists(List<ListNode> lists) {
    	if ((lists == null) || (lists.size() == 0)) {
    		return null;
    	}
        while (lists.size() > 1) {
        	lists.add(merge(lists.get(0), lists.get(1)));
        	lists.remove(0);
        	lists.remove(0);
        }
        return lists.get(0);
    }
    public ListNode merge(ListNode head1, ListNode head2) {
    	ListNode dummy = new ListNode(0);
    	ListNode cur = dummy;
    	while ((head1 != null) && (head2 != null)) {
	    	if (head1.val <= head2.val) {
	    		cur.next = head1;
	    		head1 = head1.next;
	    	} else {
	    		cur.next = head2;
	    		head2 = head2.next;
	    	}
	    	cur = cur.next;
    	}
    	if (head1 != null) {
    		cur.next = head1;
    	} else {
    		cur.next = head2;
    	}
    	return dummy.next;
    }
    public static void main(String[] args) {
    	List<ListNode> lists = new LinkedList<ListNode>();
    	lists.add(null);
    	ListNode a1 = new ListNode(-1);
    	ListNode a2 = new ListNode(5);
    	ListNode a3 = new ListNode(11);
    	a1.next = a2;
    	a2.next = a3;
    	lists.add(a1);
    	lists.add(null);
    	ListNode b1 = new ListNode(6);
    	ListNode b2 = new ListNode(10);
    	b1.next = b2;
    	lists.add(b1);
    	MergeKSortedLists solution = new MergeKSortedLists();
    	ListNode result = solution.mergeKLists(lists);
    	while (result != null) {
    		System.out.println(result.val);
    		result = result.next;
    	}
    }
}
