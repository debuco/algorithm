package chapter2.sort;

/**
 * @author bxwang
 * @date 2021/9/29
 */
public class Counting implements SortTemplate {
    @Override
    public void sort(Comparable[] a) {
        int[] counting = new int[10];
        for (Comparable num : a) {
            counting[(int) num]++;
        }

        int index = 0;
        for (int i=0; i < 10; i++) {
            while (counting[i] != 0) {
                a[index++] = i;
                counting[i] = counting[i] - 1;
            }
        }
    }
}
