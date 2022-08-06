package com.lbh.算法第四版.part1.sort;

import java.util.Arrays;

/**
 * @Description: 选择排序
 * @Author lbh
 * @Date 2021/4/19 22:37
 * @Version V1.0
 **/
public class Selection extends Sort {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, min, i);
        }
    }

    public static void main(String[] args) {
        Integer[] a = {2, 1, 4, 3, 6, 5, 8, 7, 9};
        System.out.println("排序前数组：" + Arrays.toString(a));
        sort(a);
        assert isSort(a);

        show(a);
    }
}
