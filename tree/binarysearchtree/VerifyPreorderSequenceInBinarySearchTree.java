package tree.binarysearchtree;
/**
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Follow up:
Could you do it using only constant space complexity?
 */
public class VerifyPreorderSequenceInBinarySearchTree {
	/*
	 * �൱����ԭ������ģ����ջ�Ķ���
	 */
    public boolean verifyPreorder(int[] preorder) {
        int stack = -1;
        int min = Integer.MIN_VALUE;
        for (int p : preorder) {
            if (p < min) {
                return false;
            }
            while (stack >= 0 && p > preorder[stack]) {
                min = preorder[stack];
                stack--;
            }
            stack++;
            preorder[stack] = p;
        }
        return true;
    }
}
