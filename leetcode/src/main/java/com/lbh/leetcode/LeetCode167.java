package com.lbh.leetcode;

/**
 * @Description: 给定一个已按照 升序排列的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * <p>
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * @Author lbh
 * @Date 2021/4/11 1:02
 * @Version V1.0
 **/
public class LeetCode167 {

    public int[] twoSum(int[] numbers, int target) {
        String s = "aa";
        if (numbers == null) {
            return null;
        }
        int i = 0, j = numbers.length - 1, sum = 0;
        while (i < j) {
            sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j++;
            }
        }
        return null;
    }
}
