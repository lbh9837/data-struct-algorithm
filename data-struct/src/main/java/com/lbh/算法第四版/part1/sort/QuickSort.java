package com.lbh.算法第四版.part1.sort;

/**
 * @Description: 快排
 * @Author lbh
 * @Date 2021/4/26 10:48
 * @Version V1.0
 **/
public class QuickSort extends Sort {

    /**
     * 二向切分
     **/
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    /**
     * 二向切分
     **/
    public static void sortThree(Comparable[] a) {
        sortThree(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static void sortThree(Comparable[] a, int lo, int hi) {
        int lt = lo, gt = hi, i = lo + 1;
        if (hi <= lo) {
            return;
        }
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = v.compareTo(a[i]);
            if (cmp > 0) {
                exch(a, i, lt);
                lt++;
                i++;
            } else if (cmp < 0) {
                exch(a, i, gt);
                gt--;
            } else {
                i++;
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            //从左往右扫描找到大于等于切分元素的数据
            while (less(a[++i], v)) if (i >= hi) break;
            //从右往左扫描找到小于等于切分元素的数据
            while (less(v, a[--j])) if (j <= lo) break;
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] a = {2, 1, 4, 3, 6, 5, 8, 7, 9};
        System.out.println("二向切分排序数组：");
        sort(a);
        show(a);

        System.out.println("三向切分排序数组：");
        Integer[] b = {2, 1, 4, 3, 6, 5, 8, 7, 9};
        sortThree(b);
        show(b);
    }
}
