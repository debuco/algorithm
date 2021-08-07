package chapter1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ThreeSum {
    public static int count(int[] a) {
        int count = 0;
        int size = a.length;

        for (int i=0; i < size; i++) {
            for (int j = i+1; j<size; j++) {
                for (int z=j+1; z<size; z++) {
                    if (a[i] + a[j] + a[z] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {

        int[] a= In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
