package chapter1;

import chapter1.impl.stack.FixedCapacityStack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public interface Stack<T> extends Iterable<T> {
    void push(T t);
    T pop();
    int size();
    boolean isEmpty();

    static <B> Stack<B> getFixedCapacityStack(int capacity) {
        return new FixedCapacityStack<>(capacity);
    }

    static void main(String[] args) {
        Stack<String> stack = Stack.getFixedCapacityStack(100);
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                stack.push(item);
            } else if (!stack.isEmpty()) {
                StdOut.print(stack.pop() + " ");
            }
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}
