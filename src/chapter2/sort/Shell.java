package chapter2.sort;

/**
 * @author bxwang
 *
 */
public class Shell implements SortTemplate {
    @Override
    public void sort(Comparable[] a) {
        int length = a.length;
        /*
        队列的划分很重要
         */
        int h = 1;
        while (h < length / 3) {
            h = 3 * h + 1;
        }
        while (h >=1 ) {
            for (int i=h; i < length; i++) {
                for (int j = i; j>=h && less(a[j], a[j-h]); j-=h) {
                    exch(a, j, j-h);
                }
            }
            h /= 3;
        }
    }
}
