package chapter2.priorityqueue;

/**
 * @author: bangxin.wang
 * @date: 2024/12/21 12:09
 */
public interface Max<T> {
    /**
     * 获取 最大
     * @return
     */
    T max();

    T delMax();
}
