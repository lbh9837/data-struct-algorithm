package com.lbh.leetcode;

/**
 * 4.寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * @author linbeihua
 * @date 2022/8/29 21:21
 **/
public class LeetCode4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int medianIndex = (nums1.length + nums2.length) / 2;
        boolean evenNumberFlag = (nums1.length + nums2.length) % 2 == 0;
        int i = 0;
        int j = 0;
        int index = 0;
        int[] curMedian = new int[2];
        while (medianIndex >= index) {
            curMedian[0] = curMedian[1];
            if (j >= nums2.length) {
                curMedian[1] = nums1[i];
                i++;
            } else if (i >= nums1.length) {
                curMedian[1] = nums2[j];
                j++;
            } else if (nums1[i] <= nums2[j]) {
                curMedian[1] = nums1[i];
                i++;
            } else {
                curMedian[1] = nums2[j];
                j++;
            }
            index++;
        }
        if (!evenNumberFlag) {
            curMedian[0] = curMedian[1];
        }
        return (curMedian[0] + curMedian[1]) / 2.0;
    }

    public static void main(String[] args) throws Exception {
        LeetCode4 leetCode4 = new LeetCode4();
        int[] nums1 = {1, 2};
        int[] nums2 = {3,4};
        System.out.println(leetCode4.findMedianSortedArrays(nums1, nums2));

    }

}
