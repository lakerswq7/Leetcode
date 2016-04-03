package datastructure.segmenttree;

public class RangeSumQueryMutable {
	public class NumArray {
	    class SegmentTreeNode {
	        int sum, start, end;
	        SegmentTreeNode left, right;
	        SegmentTreeNode(int start, int end) {
	            sum = 0;
	            this.start = start;
	            this.end = end;
	            left = null;
	            right = null;
	        }
	    }
	    SegmentTreeNode root;
	    private SegmentTreeNode buildTree(int start, int end, int[] nums) {
	        if (start > end) {
	            return null;
	        }
	        SegmentTreeNode r = new SegmentTreeNode(start, end);
	        if (start == end) {
	            r.sum = nums[start];
	        } else {
	            int mid = start + (end - start) / 2;
	            r.left = buildTree(start, mid, nums);
	            r.right = buildTree(mid + 1, end, nums);
	            r.sum = r.left.sum + r.right.sum;
	        }
	        return r;
	    }
	    public NumArray(int[] nums) {
	        root = buildTree(0, nums.length - 1, nums);
	    }

	    void update(int i, int val) {
	        updateTreeNode(i, val, root);
	    }
	    void updateTreeNode(int i, int val, SegmentTreeNode root) {
	        if (i == root.start && i == root.end) {
	            root.sum = val;
	        } else if (i >= root.start && i <= root.end) {
	            updateTreeNode(i, val, root.left);
	            updateTreeNode(i, val, root.right);
	            root.sum = root.left.sum + root.right.sum;
	        }
	    }

	    public int sumRange(int i, int j) {
	        return getSum(i, j, root);
	    }
	    
	    private int getSum(int i, int j, SegmentTreeNode root) {
	        if (root.start >= i && root.end <= j) {
	            return root.sum;
	        } else if (root.start > j || root.end < i) {
	            return 0;
	        } else {
	            return getSum(i, j, root.left) + getSum(i, j, root.right);
	        }
	    }
	}


	// Your NumArray object will be instantiated and called as such:
	// NumArray numArray = new NumArray(nums);
	// numArray.sumRange(0, 1);
	// numArray.update(1, 10);
	// numArray.sumRange(1, 2);
}
