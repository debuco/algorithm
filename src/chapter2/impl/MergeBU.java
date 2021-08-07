package chapter2.impl;

import chapter2.Sort;

public class MergeBU implements Sort {
    private Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        for (int sz = 1; sz <= a.length; sz = sz + sz) {
            for (int lo = 0; lo < a.length-sz; lo = lo + sz + sz) {
                mergeNative(a, lo, lo + sz - 1, Math.min(a.length - 1, lo + sz + sz - 1));
            }
        }
    }

    private void mergeNative(Comparable[] a, int lo, int mid, int high) {
        int i=lo, j=mid + 1;

        for (int k=lo; k<=high; k++) {
            aux[k] = a[k];
        }


        /**
         * 1. 左半边用尽
         * 2. 右半边用尽
         * 3. 右半边元素比左半边小
         * 4. 左半边元素比右半边小
         */
        for (int k=lo; k<=high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if(j>high) {
                a[k] = aux[i++];
            } else if (less(a[j], a[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }

    }
}
