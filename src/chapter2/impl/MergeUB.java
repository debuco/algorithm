package chapter2.impl;

import chapter2.Sort;

public class MergeUB implements Sort {
    private Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int high) {
        if (high <= lo) {
            return;
        }

        int mid = lo + (high-lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, high);
        mergeNative(a, lo, mid, high);
    }

    private void mergeNative(Comparable[] a, int lo, int mid, int high) {
        int i=lo, j=mid + 1;

        /*
            需要借助额外的辅助数组
         */
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
