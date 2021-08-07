package chapter2.impl;

import chapter2.Sort;

public class Selection implements Sort {
    @Override
    public void sort(Comparable[] a) {
        for (int i=0; i< a.length; i++) {
            int min = i;
            for (int j = i+1; j<a.length; j++) {
                if (less(a[j], min)) {
                    min = j;
                }
            }
            exch(a, min, i);
        }
    }
}
