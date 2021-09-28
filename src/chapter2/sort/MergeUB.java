package chapter2.sort;

/**
 * @author bxwang
 * @date 2021/9/28
 * 思路：
 * 将两个有序的数组合并成有序的大的数组
 * 1. 将无序的数组进行查分，然后将结果合并
 *
 * 关键点：
 * 1. 合并：merge
 * 2. 分治
 *
 * 总结：
 * 1. 时间复杂度O(NlogN)， 空间复杂度N， 稳定的非原地排序算法
 */
public class MergeUB implements SortTemplate {
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
        // 将元素暂放在辅助数组中, 辅助数组中[lo, mid]和[mid + 1, high]分别为两个已经排序好的数组
        for (int k = lo; k <= high; k++) {
            aux[k] = a[k];
        }

        // 注意这两个指针是指向辅助数组的指针
        int i=lo, j=mid+1;
        for (int k = lo; k<= high; k++) {
            // 辅助数组 [lo, mid] 左半边用尽
            if (i > mid) {
                a[k] = aux[j++];
            }

            // 辅助数组 [mid + 1, high] 右半边用尽
            else if (j > high) {
                a[k] = aux[i++];
            }

            // 比较辅助数组两个指针位置元素
            else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            }

            else {
                a[k] = aux[i++];
            }
        }

    }
}
