package datastructure.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums1) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int n : nums2) {
            if (map.containsKey(n)) {
                list.add(n);
                if (map.get(n) == 1) {
                    map.remove(n);
                } else {
                    map.put(n, map.get(n) - 1);
                }
            }
        }
        int[] rst = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            rst[i] = list.get(i);
        }
        return rst;
    }
    //排序以后算法
    public int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0, index2 = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                list.add(nums1[index1]);
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        int[] rst = new int[list.size()];
        int i = 0;
        for (int n : list) {
            rst[i++] = n;
        }
        return rst;
    }
    // 如果nums2比nums1大很多,用binary search
    public int[] intersect3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int left = 0, right = nums2.length - 1;
        for (int i = 0; i < nums1.length; i++) {
            int index = bs(nums2, left, right, nums1[i]);
            if (nums2[index] == nums1[i]) {
                list.add(nums1[i]);
                left = index + 1;
            } else {
                left = index;
            }
            if (left > right) {
                break;
            }
        }
        int[] rst = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            rst[i] = list.get(i);
        }
        return rst;
    }
    private int bs(int[] array, int low, int high, int target) {
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (target <= array[low]) {
            return low;
        }
        return high;
    }
    
}
