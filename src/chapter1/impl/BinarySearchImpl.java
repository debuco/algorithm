package chapter1.impl;

import chapter1.BinarySearch;

import java.util.Objects;

/**
 * @author: bangxin.wang
 * @date: 2024/12/14 15:23
 */
public class BinarySearchImpl implements BinarySearch {

    @Override
    public int rank(int value, int[] values) {
        if (Objects.isNull(values)) {
            return -1;
        }

        return searchvalue(0, values.length - 1, values, value);
    }

    private int searchvalue(int lo, int hi, int[] values, int value) {
        if (lo > hi) {
            return -1;
        }
        int mid = (hi - lo) / 2 + lo;
        if (value == values[mid]) {
            return mid;
        } else if (value < values[mid]) {
            return searchvalue(lo, mid - 1, values, value);
        } else {
            return searchvalue(mid + 1, hi, values, value);
        }
    }
}
