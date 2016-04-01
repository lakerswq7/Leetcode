package array;

public class FindTheDuplicateNumber {
	/*
	 * ֻ�������,������ÿһ��Ԫ�������linkedlist��һ���ڵ㣬�������˼����
	 * ��linkedlist�����һ��������һ����
	 */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        int third = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
            if (slow == fast) {
                break;
            }
        }
        while (third != slow) {
            third = nums[third];
            slow = nums[slow];
        }
        return slow;
    }
	/*
	 * ���Խ��������
	 */
    public int findDuplicate2(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int temp = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = temp;
        }
        return nums[0];
    }
}
