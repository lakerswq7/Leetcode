package tree.binarytree;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        Result result = getMaxSum(root);
        return result.maxSum;
    }
    public Result getMaxSum(TreeNode root) {
    	// 最大值必须得取，所以如果是null的话就去MIN_VALUE, 单路值可以不取，所以如果是null的话就不取，设为0
        if (root == null) {
            return new Result(Integer.MIN_VALUE, 0);
        }
        Result left = getMaxSum(root.left);
        Result right = getMaxSum(root.right);
        
        // 因为从底下传上来的一定不是负数，所以如果这里为负数，说明root是负数，所以就不取
        int singleSum = Math.max(Math.max(left.singleSum, right.singleSum) + root.val, 0);
        // 三种情况，左边最大的，右边最大的，或者两个单边值加起来再跨root
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