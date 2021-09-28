package chapter2.sort;

/**
 * @author bxwang
 * @date 2021/9/28
 * 思路：
 * 切记：往数组前部前比较，就像打牌一样
 *
 * 总结：
 * 1. 插入排序所需的时间取决于输入中元素的初始顺序，对于部分有序的数组十分高效
 * 2. 移动数据比较多
 * 3. 时间复杂度O(N)到O(N^2)之间，空间复杂度 1， 稳定的原地排序
 */
public class Insertion implements SortTemplate {
    @Override
    public void sort(Comparable[] a) {
        int length = a.length;
        for (int i=1; i<length; i++) {

            for (int j=i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j-1, j);
            }
        }
    }

    public void sort2(Comparable[] a) {

    }
}
