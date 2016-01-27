package linkedlist;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        ListNode small = new ListNode(0);
        ListNode smallCur = small;
        ListNode big = new ListNode(0);
        ListNode bigCur = big;
        while (cur != null) {
            if (cur.val < x) {
                smallCur.next = cur;
                smallCur = smallCur.next;
            } else {
                bigCur.next = cur;
                bigCur = bigCur.next;
            }
            cur = cur.next;
        }
        // ����ע��Ҫ�Ѵ���ǲ������һ����Ϊnull
        bigCur.next = null;
        smallCur.next = big.next;
        return small.next;
    }
}
