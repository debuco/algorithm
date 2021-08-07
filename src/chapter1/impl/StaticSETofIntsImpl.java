package chapter1.impl;

import chapter1.StaticSETofInts;

import java.util.Arrays;

public class StaticSETofIntsImpl implements StaticSETofInts {
    private int[] a;

    public StaticSETofIntsImpl(int[] a) {
        this.a = new int[a.length];
        for (int i=0; i<a.length; i++) {
            this.a[i] = a[i];
        }
        Arrays.sort(this.a);
    }

    @Override
    public boolean contains(int key) {
        return range(key, a) != -1;
    }

    private int range(int key, int[] a) {
        int lo = 0;
        int high = a.length;
        while (lo < high) {
            int mid = lo + (high - lo) / 2;
            if (key < a[mid]) {
                high = mid;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
