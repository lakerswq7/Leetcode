package tree.binarytree;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        Result result = getMaxSum(root);
        return result.maxSum;
    }
    public Result getMaxSum(TreeNode root) {
    	// ���ֵ�����ȡ�����������null�Ļ���ȥMIN_VALUE, ��·ֵ���Բ�ȡ�����������null�Ļ��Ͳ�ȡ����Ϊ0
        if (root == null) {
            return new Result(Integer.MIN_VALUE, 0);
        }
        Result left = getMaxSum(root.left);
        Result right = getMaxSum(root.right);
        
        // ��Ϊ�ӵ��´�������һ�����Ǹ����������������Ϊ������˵��root�Ǹ��������ԾͲ�ȡ
        int singleSum = Math.max(Math.max(left.singleSum, right.singleSum) + root.val, 0);
        // ���������������ģ��ұ����ģ�������������ֵ�������ٿ�root
        int maxSum = Math.max(Math.max(left.maxSum, right.maxSum), left.singleSum + right.singleSum + root.val);
        return new Result(maxSum, singleSum);
    }
}
class Result {
    int maxSum;
    int singleSum;
    Result(int maxSum, int singleSum) {
        this.maxSum = maxSum;
        this.singleSum = singleSum;
    }
}