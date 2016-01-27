package linkedlist;


public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode cur = first;
        ListNode check = head;
        ListNode temp;
        // ������Ҫע�⣬�Ժ�����linked listɾ���Ͳ���������Ҫ��סǰһ���ڵ㣬�����һ���ڵ�
        while (check.next != null) {
        	// ����ѭ���鲢��һ��ѭ������������ע����Ϊcheck�ļ���������ѭ�������У����Ե�������check֮��
        	// һ��Ҫ���¿�ʼѭ�����Լ��check�ĺϷ���
            if (check.next == cur.next) {
                cur = first;
                check = check.next;
                continue;
            }
            if (check.next.val <= cur.next.val) {
            	// �Ȱ�check.next�������ó������ٰ����嵽cur�ĺ���ȥ
                temp = check.next;
                check.next = check.next.next;
                temp.next = cur.next;
                cur.next = temp;
                cur = first;
            } else {
                cur = cur.next;
            }
        }
        return first.next;
    }
	public static void main(String[] args) {
		ListNode a = new ListNode(3);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(4);
		a.next = b;
		b.next = c;
		InsertionSortList solution = new InsertionSortList();
		ListNode d = solution.insertionSortList(a);
		System.out.println(d.val);
		System.out.println(d.next.val);
		System.out.println(d.next.next.val);
	}
}
