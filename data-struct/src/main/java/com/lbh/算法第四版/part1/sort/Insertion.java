package com.lbh.算法第四版.part1.sort;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author lbh
 * @Date 2021/5/12 18:55
 * @Version V1.0
 **/
public class Insertion extends Sort {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
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
