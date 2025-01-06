package chapter4.mstree;

import chapter1.Queue;
import chapter1.impl.queue.SinglyLinkedQueue;
import chapter2.priorityqueue.MinPriorityQueue;


/**
 * 贪心算法，从一个图的节点出发，一步步找到最小权重的横切边，创建最小生成树
 *
 * @author: bangxin.wang
 * @date: 2025/1/5 13:53
 */
public class LazyPrimMST implements Mst {
    // 最小生成树的权重
    private double weight;
    // 最小生成树的边
    private Queue<Edge> mst;
    // marked[v] = true iff v on tree
    private boolean[] marked;
    // edges with one endpoint in tree
    private MinPriorityQueue<Edge> pq;

    /**
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     *
     * @param edgeWeightedGraph the edge-weighted graph
     */
    public LazyPrimMST(EdgeWeightedGraph edgeWeightedGraph) {
        mst = new SinglyLinkedQueue<>();
        pq = new MinPriorityQueue<>(edgeWeightedGraph.E());
        marked = new boolean[edgeWeightedGraph.V()];
        // run Prim from all vertices to
        for (int v = 0; v < edgeWeightedGraph.V(); v++)
        // get a minimum spanning forest
        {
            if (!marked[v]) {
                prim(edgeWeightedGraph, v);
            }
        }
    }

    // run Prim's algorithm
    private void prim(EdgeWeightedGraph G, int s) {
        scan(G, s);
        // better to stop when mst has V-1 edges
        while (!pq.isEmpty()) {
            // 找到最小的横切边
            Edge e = pq.delMin();
            // two endpoints
            int v = e.either(), w = e.other(v);
            // 这里的判断是有必要的，因为每次只弹出一个，并没有删除已失效的边
            if (marked[v] && marked[w]) {
                // lazy, both v and w already scanned
                continue;
            }
            // add e to MST
            mst.enqueue(e);
            weight += e.weight();
            if (!marked[v]) {
                // v becomes part of tree
                scan(G, v);
            }
            if (!marked[w]) {
                // w becomes part of tree
                scan(G, w);
            }
        }
    }

    // add all edges e incident to v onto pq if the other endpoint has not yet been scanned
    private void scan(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            // 此处包含了已经扫描过的节点不符合横切边，则跳过该边加入小顶堆
            if (!marked[e.other(v)]) {
                // 将边入小顶堆
                pq.insert(e);
            }
        }
    }

    /**
     * Returns the edges in a minimum spanning tree (or forest).
     *
     * @return the edges in a minimum spanning tree (or forest) as
     * an iterable of edges
     */
    @Override
    public Iterable<Edge> edges() {
        return mst;
    }

    /**
     * Returns the sum of the edge weights in a minimum spanning tree (or forest).
     *
     * @return the sum of the edge weights in a minimum spanning tree (or forest)
     */
    @Override
    public double weight() {
        return weight;
    }

}
