package chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = Stack.getFixedCapacityStack(100);
        Stack<Double> values = Stack.getFixedCapacityStack(100);

        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("(")){

            } else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")) {
                ops.push(s);
            } else if (s.equals(")")) {
                String op = ops.pop();
                Double val = values.pop();
                if (op.equals("+")) {
                    values.push(values.pop() + val);
                } else if (op.equals("-")) {
                    values.push(values.pop() - val);
                } else if (op.equals("*")) {
                    values.push(values.pop() * val);
                } else if (op.equals("/")) {
                    values.push(values.pop() / val);
                } else if (op.equals("sqrt")) {
                    values.push(Math.sqrt(val));
                }
            } else {
                values.push(Double.parseDouble(s));
            }
        }
        StdOut.println(values.pop());
    }
}
