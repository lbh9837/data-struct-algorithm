package com.lbh.算法第四版.part1.sort;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author lbh
 * @Date 2021/5/12 20:27
 * @Version V1.0
 **/
public class Shell extends Sort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N) {
            //1,4,13,40...
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
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
