package linkedlist;

public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode newCur = dummy;
        while (cur != null) {
            newCur.next = cur.next;
            newCur = newCur.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
}