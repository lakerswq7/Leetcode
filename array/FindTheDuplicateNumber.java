package array;

public class FindTheDuplicateNumber {
	/*
	 * 只读的情况,把数组每一个元素想象成linkedlist的一个节点，所以这个思想与
	 * 在linkedlist里面找环的起点是一样的
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
	 * 可以交换的情况
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
