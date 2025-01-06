package chapter4.mstree;

import chapter1.Bag;
import chapter1.impl.bag.SinglyLinkedBag;

/**
 *
 *
 * @author: bangxin.wang
 * @date: 2024/12/23 19:48
 */
public class EdgeWeightedGraph {

    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    /**
     * v 个顶点的无向图
     *
     * @param V
     */
    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.adj = new SinglyLinkedBag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new SinglyLinkedBag<>();
        }
    }

    /**
     * 图的顶点数
     *
     * @return
     */
    public int V() {
        return V;
    }

    /**
     * 图的边数
     *
     * @return
     */
    public int E() {
        return E;
    }

    /**
     * @param edge
     */
    public void addEdge(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);
        Bag<Edge> vBag = adj[v];
        vBag.add(edge);
        Bag<Edge> wBag = adj[w];
        wBag.add(edge);
        E++;
    }


    /**
     * 和v相关联的所有边
     *
     * @param v
     * @return
     */
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    /**
     * 图的所有边
     *
     * @return
     */
    public Iterable<Edge> edges() {
        Bag<Edge> edges = new SinglyLinkedBag<>();
        for (int v = 0; v < V(); v++) {
            for (Edge edge : adj(v)) {
                // 此处确保一个相同的无向边被添加一次
                if (edge.other(v) > v) {
                    edges.add(edge);
                }
            }
        }
        return edges;
    }
}
