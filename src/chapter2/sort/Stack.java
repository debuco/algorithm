package chapter2.sort;

/**
 * @author bxwang
 * @date 2021/9/29 21:03
 * 思路：
 * 1. 将所有元素插入一个查找最小元素的优先队列
 * 2. 然后重复调用删除最小元素的操作来将它们按照顺序删除
 * ·用无序队列的实现相当于一次选择排序
 * ·用基于堆的优先队列---堆排序
 * 阶段1：堆的构造
 * 阶段2：下沉阶段取出所有元素
 *
 */
public class Stack implements SortTemplate {
    @Override
    public void sort(Comparable[] a) {
        int len = a.length - 1;
        int beginIndex = len >> 1;
        for (int i = beginIndex; i>=0; i--) {
            sink(a, i, len);
        }

        for (int i = len; i <= 0; i--) {
            exch(a, 0, i);
            sink(a, 0, i-1);
        }
    }

    private void sink(Comparable[] a, int i, int len) {
        // 左子节点index
        int li = (i << 1) + 1;
        int ri = (i << 1) + 2;

        if (li > len) {
            return;
        }

        int cMax = li;
        if (ri <= len && less(a[li], a[ri])) {
            cMax = ri;
        }

        if (less(a[i], a[cMax])) {
            exch(a, i, cMax);
            sink(a, cMax, len);
        }
    }
}
