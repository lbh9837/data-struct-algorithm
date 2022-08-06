package com.lbh.算法第四版.part1.sort;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author lbh
 * @Date 2021/5/13 0:44
 * @Version V1.0
 **/
public class Merge extends Sort {

    private static Comparable[] aux;

    /**
     * 自顶向下归并
     **/
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    /**
     * 自底向上归并
     **/
    public static void SortBU(Comparable[] a) {
        int N = a.length;
        for (int size = 1; size < N; size = size + size) {
            for (int lo = 0; lo <= N; lo = lo + size + size) {
                merge(a, lo, lo + size - 1, lo + size + size - 1);
            }
        }
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(a[j], a[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }

    }

    public static void main(String[] args) {
        Integer[] a = {2, 1, 4, 3, 6, 5, 8, 7, 9};
        System.out.println("排序前数组：" + Arrays.toString(a));
        sort(a);
        assert isSort(a);
        System.out.println("自顶向下排序后数据： ");
        show(a);

        Integer[] b = {2, 1, 4, 3, 6, 5, 8, 7, 9};
        sort(a);
        System.out.println("自底向上排序后数据： ");
        show(a);
    }
}
