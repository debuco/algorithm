package chapter4.sptree.impl;

import chapter4.sptree.DirectedEdge;

/**
 * @author: bangxin.wang
 * @date: 2025/1/6 15:53
 */
public class DirectedEdgeImpl implements DirectedEdge {
    private int from;
    private int to;
    private double weight;

    public DirectedEdgeImpl(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public int from() {
        return from;
    }

    @Override
    public int to() {
        return to;
    }
}
