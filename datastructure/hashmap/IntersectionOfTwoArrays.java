package datastructure.hashmap;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int n : nums1) {
            set.add(n);
        }
        HashSet<Integer> rst = new HashSet<Integer>();
        for (int n : nums2) {
            if (set.contains(n)) {
                rst.add(n);
            }
        }
        int[] intersection = new int[rst.size()];
        int index = 0;
        for (int n : rst) {
            intersection[index++] = n;
        }
        return intersection;
    }
    //排序以后的算法
    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        HashSet<Integer> rst = new HashSet<Integer>();
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                rst.add(nums1[index1]);
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        int[] intersection = new int[rst.size()];
        int i = 0;
        for (int n : rst) {
            intersection[i++] = n;
        }
        return intersection;
    }
    // 排序以后binary search
    public int[] intersection3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int left = 0, right = nums1.length - 1;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            int index = binarySearch(nums1, nums2[i], left, right);
            if (nums1[index] == nums2[i]) {
                set.add(nums2[i]);
            }
            left = index;
        }
        int i = 0;
        int[] rst = new int[set.size()];
        for (int n : set) {
            rst[i++] = n;
        }
        return rst;
    }
    private int binarySearch(int[] array, int target, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (array[left] >= target) {
            return left;
        }
        return right;
    }
}
