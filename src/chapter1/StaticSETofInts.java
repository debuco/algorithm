package chapter1;

import chapter1.impl.StaticSETofIntsImpl;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public interface StaticSETofInts {
    boolean contains(int key);

    static boolean containsKey(int key, int[] a) {
        return new StaticSETofIntsImpl(a).contains(key);
    }

    static StaticSETofInts getStaticSETofInts(int[] a) {
        return new StaticSETofIntsImpl(a);
    }

    static void main(String[] args) {
        int[] w = In.readInts(args[0]);
        StaticSETofInts staticSETofInts = StaticSETofInts.getStaticSETofInts(w);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();

            if (!staticSETofInts.contains(key)) {
                StdOut.println(key);
            }
        }
    }
}
