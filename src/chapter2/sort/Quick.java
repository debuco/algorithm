package chapter2.sort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author bxwang
 * @date 2021/9/28 21:27
 * 思路：
 * 1. 分治
 *  将一个数组分成两个子数组，将两部分独立排序
 * 2. 切分
 *  · 对于某个j, a[j]已排定
 *  · a[lo]到a[j-1]中的所有元素都不大于a[j]
 *  · a[j+1]到a[high]中的所有元素都不小于a[j]
 * 3. 随机化
 *
 * 总结：
 * 1. 时间复杂度O(NlogN), 空间复杂度 1， 非稳定的原地排序
 */
public class Quick implements SortTemplate {
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
        // 注意这里的指针边界
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
