package chapter2.impl;

import chapter2.Sort;

public class Bublle implements Sort {
    @Override
    public void sort(Comparable[] a) {
        boolean swapped = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int j = 0; j < (a.length - 1 - i); j++) {
                if (less(a[j + 1], a[j])) {
                    exch(a, j+1, j);
                    swapped = true;
                }
            }
        }
    }
}
