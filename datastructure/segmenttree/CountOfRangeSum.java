package datastructure.segmenttree;

import java.util.Arrays;

public class CountOfRangeSum {
/*
 * 这题在对数组进行求prefix sum的预处理以后
 * 跟count of smaller numbers after self差不多
 * 可以用segment tree的解法或者binary search tree解法
 */
	
/*
 * segment tree 解法, 这里用到的离散方法是，将数组排序，以数组中去重后具体的值作为叶子节点
 */
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long sums[] = new long[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        long sum = sums[sums.length - 1];
        Arrays.sort(sums);
        int len = deduplicate(sums);
        STNode root = buildTree(sums, 0, len);
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            update(root, sum);
            sum -= nums[i];
            count += getSum(root, lower + sum, upper + sum);
        }
        return count;
    }
    private int deduplicate(long[] sums) {
        int len = 0;
        for (int i = 0; i < sums.length; i++) {
            if (i == 0 || sums[i] != sums[i - 1]) {
                sums[len++] = sums[i];
            }
        }
        return len - 1;
    }
    private STNode buildTree(long[] sums, int start, int end) {
        STNode root = new STNode(sums[start], sums[end]);
        if (start == end) {
            return root;
        }
        int mid = start + (end - start) / 2;
        root.left = buildTree(sums, start, mid);
        root.right = buildTree(sums, mid + 1, end);
        return root;
    }
    private int getSum(STNode root, long start, long end) {
        if (end < root.start || start > root.end) {
            return 0;
        }
        if (start <= root.start && end >= root.end) {
            return root.sum;
        }
        return getSum(root.left, start, end) + getSum(root.right, start, end);
    }
    private void update(STNode root, long val) {
        if (val == root.start && val == root.end) {
            root.sum++;
        } else if (val >= root.start && val <= root.end) {
            root.sum++;
            update(root.left, val);
            update(root.right, val);
        }
    }
    class STNode {
        long start, end;
        int sum;
        STNode left, right;
        STNode(long start, long end) {
            this.start = start;
            this.end = end;
            sum = 0;
            left = null;
            right = null;
        }
    }
    /*
     * binary search tree 解法
     */
    public int countRangeSum2(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long sums[] = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        BST root = new BST(sums[sums.length - 1]);
        int count = 0;
        for (int i = sums.length - 2; i >= 0; i--) {
            int smaller1 = countSmaller(root, sums[i] + lower, false);
            int smaller2 = countSmaller(root, sums[i] + upper, true);
            count += smaller2 - smaller1;
            insert(root, sums[i]);
        }
        return count;
    }
    private int countSmaller(BST root, long val, boolean isIncl) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if ((isIncl && val >= root.val) || (!isIncl && val > root.val)) {
            count += root.count + 1;
            count += countSmaller(root.right, val, isIncl);
        } else {
            count += countSmaller(root.left, val, isIncl);
        }
        return count;
    }
    private void insert(BST root, long val) {
        if (root.val < val) {
            if (root.right == null) {
                root.right = new BST(val);
            } else {
                insert(root.right, val);
            }
        } else {
            root.count++;
            if (root.left == null) {
                root.left = new BST(val);
            } else {
                insert(root.left, val);
            }
        }
    }
    class BST {
        long val;
        int count;
        BST left, right;
        BST(long val) {
            this.val = val;
            left = null;
            right = null;
            count = 0;
        }
    }
}
