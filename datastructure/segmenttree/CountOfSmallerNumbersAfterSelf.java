package datastructure.segmenttree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
/*
 * binary search tree�Ľⷨ���ⷨ��ȱ�����������¸��ӶȻ���O(n^2)
 * ��Ϊ������ƽ���
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
     * segment tree�Ľⷨ, Ҳ���������������ֵ��Сֵ��Ϊ�߶����ķ�Χ���������Ӷȿ��ܻ����
     * ��ʱ�������ְ취
     * 1. �����õ����±�ķ�Χ�����߶����ķ�Χ���Ӻ���ǰ��������õ��±�����壬�ٿ��Ѿ��ж��ٱ�
     * ��ǰ��С���±���
     * 2. ������ʱ�����±�ķ�ΧΪ��׼���������ұ߽�����Ӧ�������е�ֵ������ÿһ��Ҷ�ӽڵ㲻����
     * ��ʾÿһ����һ��ɢ��ֵ�ˣ����Ǳ�ʾһ��������ȷ����ֵ�������Ǵ�С�������еģ���ʱ���ٰ���ԭ��
     * �����˳��һ��һ���������Ѱ�ҡ� ע����sort��֮����Ҫȥ�أ�����Ҷ�ӽڵ������ظ��Ľڵ�
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
     * �����merge sort���������ķ���������merge sort �ȶ���������ԣ���merge sort�����У� 
     * ����ÿһ���ڵ��ж��ٺ���Ľڵ��Ƶ�����֮ǰ�������沢û���޸�ԭ���飬���ǲ����޸������±�ķ�ʽ��
     * Ŀ����ͨ���±꽨����ԭ����Ķ�Ӧ��ϵ��ʹcount�����ܶ�Ӧ��ԭ�����λ��
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
