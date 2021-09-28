package chapter2.sort;

import edu.princeton.cs.algs4.StdOut;

public interface SortTemplate {
    void sort(Comparable[] a);

    default boolean less(Comparable v1, Comparable v2) {
        return v1.compareTo(v2) < 0;
    }

    default void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    default void show(Comparable[] a) {
        for (int i=0; i<a.length; i++) {
            StdOut.print(a[i] + " ");
        }

        StdOut.println();
    }

    default boolean isSorted(Comparable[] a) {
        for (int i=1; i< a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }
}
