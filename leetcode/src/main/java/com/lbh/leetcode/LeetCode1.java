package com.lbh.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
 *
 * @author linbeihua
 * @date 2022/8/3 18:51
 **/
public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] sum = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                sum[0] = map.get(nums[i]);
                sum[1] = i;
                break;
            }
            map.put(target - nums[i], i);
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode1 leetCode1 = new LeetCode1();

        int[] nums = {3, 3};
        int target = 6;
        System.out.println(Arrays.toString(leetCode1.twoSum(nums, target)));
    }
}
