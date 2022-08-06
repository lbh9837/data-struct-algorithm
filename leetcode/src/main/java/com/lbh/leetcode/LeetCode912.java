package com.lbh.leetcode;

import java.util.List;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * @Author lbh
 * @Date 2021/7/31 1:49
 * @Version V1.0
 **/
public class LeetCode912 {

    public int[] sortArray(int[] nums) {
        selectSort(nums);
        return nums;
    }

    /**
     * 选择排序
     **/
    public void selectSort(int[] nums) {
        int min;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            min = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            exchange(nums, i, min);
        }
    }

    /**
     * 插入排序
     **/
    public void insertSort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    exchange(nums, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 优化插入排序
     **/
    public void insertSort2(int[] nums) {
        int len = nums.length;
        int cur;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (j == 0) {
                    exchange(nums, i, j);
                    break;
                } else if (nums[i] > nums[i - 1]) {
                    break;
                }
                if (nums[j] < nums[i]) {
                    cur = nums[i];
                    int destPos = Math.min(i, j + 2);
                    System.arraycopy(nums, j + 1, nums, destPos, i - j - 1);
                    nums[j + 1] = cur;
                    break;
                }
            }
        }
    }


    public void exchange(int[] nums, int i, int j) {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }
}
