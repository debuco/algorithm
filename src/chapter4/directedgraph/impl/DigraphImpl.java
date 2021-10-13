package chapter4.directedgraph.impl;

import chapter1.Bag;
import chapter1.impl.bag.SinglyLinkedBag;
import chapter4.directedgraph.Digraph;

/**
 * @author bxwang
 * @date 2021/10/12 20:03
 */
public class DigraphImpl extends Digraph {

    private int E;

    private Bag<Integer>[] adj;

    public DigraphImpl(int v) {
        super(v);

        this.E = 0;

        adj = new SinglyLinkedBag[v];
        for (int i=0; i< v; i++) {
            adj[i] = new SinglyLinkedBag<>();
        }
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public Digraph reverse() {
        Digraph digraph = new DigraphImpl(V());
        for (int i = 0; i<V(); i++) {
            for (int w : adj(i)) {
                digraph.addEdge(w, i);
            }
        }
        return digraph;
    }
}
