package chapter2.impl;

import chapter2.Sort;

public class Insertion implements Sort {
    @Override
    public void sort(Comparable[] a) {
       for (int i = 1; i<a.length; i++) {
           for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
               exch(a, j , j-1);
           }
       }

    }

    public void sort2(Comparable[] a) {
        for (int i = 1; i<a.length; i++) {
            Comparable item = a[i];
            int j = i - 1;
            for (; j >= 0 && less(a[i], a[j]); j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = item;
        }
    }
}
