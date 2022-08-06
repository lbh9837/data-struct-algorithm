package com.lbh.算法第四版.part1.sort;

/**
 * @Description: TODO
 * @Author lbh
 * @Date 2021/4/12 3:13
 * @Version V1.0
 **/
public abstract class Sort {

    /**
     * if v < w return true
     **/
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        if (a == null || a.length == 0) return;
        for (Comparable comparable : a) {
            System.out.print(comparable + " ");
        }
        System.out.println("\n");
    }

    public static boolean isSort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
