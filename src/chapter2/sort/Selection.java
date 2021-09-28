package chapter2.sort;

/**
 * @author bxwang
 * @date 2021/9/28
 * 思路：
 * 1. 遍历数组，比较找到最小的元素，交换
 *
 * 总结：
 * 1. 运行速度和输入无关
 *      即输入数组的状态不能为下一次循环提供任何有用的信息
 * 2. 数据移动少
 * 3. 时间复杂度O(N^2), 空间复杂度 1， 非稳定的原地排序
 */
public class Selection implements SortTemplate {
    @Override
    public void sort(Comparable[] a) {
       for (int i=0; i<a.length; i++) {
           int minIndex = i;
           for (int j=i; j<a.length; j++) {
               if (less(j, minIndex)) {
                   minIndex = j;
               }
           }
           exch(a, minIndex, i);
       }
    }
}
