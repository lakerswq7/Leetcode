package datastructure.segmenttree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
/*
 * binary search tree的解法，解法的缺点是最坏的情况下复杂度还是O(n^2)
 * 因为树不是平衡的
 */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> rst = new ArrayList<Integer>();
        BSTNode root = new BSTNode(Integer.MAX_VALUE);
        BSTNode last = null, temp = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            int count = 0;
            temp = root;
            while (temp != null) {
                last = temp;
                if (nums[i] > temp.val) {
                    count = count + temp.count + 1;
                    temp = temp.right;
                } else {
                    temp.count++;
                    temp = temp.left;
                }
            }
            if (nums[i] > last.val) {
                last.right = new BSTNode(nums[i]);
            } else {
                last.left = new BSTNode(nums[i]);
            }
            rst.add(0, count);
        }
        return rst;
    }
    class BSTNode {
        int count;
        int val;
        BSTNode left, right;
        BSTNode(int val) {
            count = 0;
            this.val = val;
            left = null;
            right = null;
        }
    }
    /*
     * segment tree的解法, 也可以以数组中最大值最小值作为线段树的范围，那样复杂度可能会提高
     * 这时候有两种办法
     * 1. 这里用的是下标的范围来做线段树的范围，从后往前，把排序好的下标往里插，再看已经有多少比
     * 当前点小的下标了
     * 2. 建树的时候用下标的范围为基准，但是左右边界用相应的数组中的值，这样每一个叶子节点不再是
     * 表示每一个单一离散的值了，而是表示一个数组中确定的值，并且是从小到大排列的，这时候再按照原来
     * 数组的顺序一个一个往里插来寻找。 注意在sort完之后需要去重，否则叶子节点会出现重复的节点
     */
    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> rst = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Arrays.binarySearch(tmp, nums[i]);
        }
        STNode root = buildTree(0, nums.length - 1);
        for (int i = nums.length - 1; i >= 0; i--) {
            update(root, nums[i], 1);
            rst.add(0, query(root, 0, nums[i] - 1));
        }
        return rst;
    }
    private STNode buildTree(int start, int end) {
        STNode root = new STNode(start, end);
        if (start < end) {
            int mid = start + (end - start) / 2;
            root.left = buildTree(start, mid);
            root.right = buildTree(mid + 1, end);
        }
        return root;
    }
    private int query(STNode root, int start, int end) {
        if (root.start >= start && root.end <= end) {
            return root.sum;
        } else if (root.start > end || root.end < start) {
            return 0;
        } else {
            return query(root.left, start, end) + query(root.right, start, end);
        }
    }
    private void update(STNode root, int pos, int val) {
        if (pos == root.start && pos == root.end) {
            root.sum += val;
        } else if (pos >= root.start && pos <= root.end){
            update(root.left, pos, val);
            update(root.right, pos, val);
            root.sum = root.left.sum + root.right.sum;
        }
    }
    class STNode {
        int start, end, sum;
        STNode left, right;
        STNode(int start, int end) {
            this.start = start;
            this.end = end;
            sum = 0;
            left = null;
            right = null;
        }
    }
    /*
     * 这就是merge sort求逆序数的方法，利用merge sort 稳定排序的特性，在merge sort过程中， 
     * 看看每一个节点有多少后面的节点移到了他之前，这里面并没有修改原数组，而是采用修改数组下标的方式，
     * 目的是通过下标建立和原数组的对应关系，使count数组能对应到原数组的位置
     */
    public List<Integer> countSmaller3(int[] nums) {
        List<Integer> rst = new ArrayList<Integer>();
        int[] count = new int[nums.length];
        int[] helper = new int[nums.length];
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        mergeSort(nums, 0, nums.length - 1, count, helper, index);
        for (int c : count) {
            rst.add(c);
        }
        return rst;
    }
    private void mergeSort(int[] nums, int start, int end, int[] count, int[] helper, int[] index) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid, count, helper, index);
            mergeSort(nums, mid + 1, end, count, helper, index);
            merge(nums, start, mid, end, count, helper, index);
        }
    }
    private void merge(int[] nums, int start, int mid, int end, int[] count, int[] helper, int[] index) {
        int countRight = 0;
        int cur = start, left = start, right = mid + 1;
        for (int i = start; i <= end; i++) {
            helper[i] = index[i];
        }
        while (left <= mid && right <= end) {
            if (nums[helper[left]] <= nums[helper[right]]) {
                index[cur] = helper[left];
                count[index[cur]] += countRight;
                left++;
            } else {
                index[cur] = helper[right];
                right++;
                countRight++;
            }
            cur++;
        }
        while(left <= mid) {
			index[cur] = helper[left];
			count[index[cur]] += countRight;
			cur++;
			left++;
		}
    }
}
