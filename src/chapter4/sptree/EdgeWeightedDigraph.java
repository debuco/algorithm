package chapter4.sptree;

/**
 * @author: bangxin.wang
 * @date: 2025/1/6 15:51
 */
public interface EdgeWeightedDigraph {
    /**
     * 顶点的数量
     *
     * @return
     */
    int V();

    /**
     * 边的数量
     *
     * @return
     */
    int E();


    /**
     * add edge
     *
     * @param directedEdge
     */
    void addEdge(DirectedEdge directedEdge);


    /**
     * 从v 指出的边
     *
     * @param v
     * @return
     */
    Iterable<DirectedEdge> adj(int v);
}
