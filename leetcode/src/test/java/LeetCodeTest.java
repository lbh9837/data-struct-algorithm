import com.lbh.leetcode.LeetCode912;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author lbh
 * @Date 2021/7/31 2:18
 * @Version V1.0
 **/
public class LeetCodeTest {


    @Test
    public void test912() {
        LeetCode912 leetCode912 = new LeetCode912();
        int[] nums = {5, 2, 3, 1};
        //选择排序
        leetCode912.selectSort(nums);
        System.out.println("选择排序" + Arrays.toString(nums));

        //插入排序
        int[] nums2 = {2, 1, 4, 3, 6, 5, 8, 7, 9};
        leetCode912.insertSort2(nums2);
        System.out.println("插入排序" + Arrays.toString(nums2));
    }
}
