package chapter4.sptree.impl;

import chapter1.Bag;
import chapter1.impl.bag.SinglyLinkedBag;
import chapter4.sptree.DirectedEdge;
import chapter4.sptree.EdgeWeightedDigraph;

/**
 * @author: bangxin.wang
 * @date: 2025/1/6 15:55
 */
public class EdgeWeightedDigraphImpl implements EdgeWeightedDigraph {

    private Bag<DirectedEdge>[] adj;

    private int v;

    private int e;

    public EdgeWeightedDigraphImpl(int v) {
        this.v = v;
        this.adj = new SinglyLinkedBag[v];
        for (int i = 0; i < v; i++) {
            this.adj[i] = new SinglyLinkedBag<>();
        }
    }

    @Override
    public int V() {
        return v;
    }

    @Override
    public int E() {
        return v;
    }

    @Override
    public void addEdge(DirectedEdge directedEdge) {
        int from = directedEdge.from();
        this.adj[from].add(directedEdge);
        e++;
    }

    @Override
    public Iterable<DirectedEdge> adj(int v) {
        return this.adj[v];
    }
}
