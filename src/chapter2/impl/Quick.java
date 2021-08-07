package chapter2.impl;

import chapter2.Sort;
import edu.princeton.cs.algs4.StdRandom;

public class Quick implements Sort {
    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int high) {
        if (high <= lo) {
            return;
        }
        int p = partition(a, lo, high);
        sort(a, lo, p-1);
        sort(a, p + 1, high);
    }

    private int partition(Comparable[] a, int lo, int high) {
        Comparable partItem = a[lo];
        int i = lo, j = high + 1;
        while (true) {
            while (less(a[++i], partItem)){
                if (i >= high) {
                    break;
                }
            }
            while (less(partItem, a[--j])) {
                if (j <= lo) {
                    break;
                }
            }
            if (i>=j)  {
                break;
            }
            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;

    }
}
