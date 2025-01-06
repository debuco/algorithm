package chapter4.sptree;

/**
 * 单原始起点最短链路
 *
 * @author: bangxin.wang
 * @date: 2025/1/6 16:02
 */
public interface ShortestPath {
    /**
     * 从顶点s 到 节点v 的最短路径
     *
     * @param v
     * @return
     */
    double distTo(int v);

    /**
     * 从顶点s 到 节点v 间是否存在路径
     *
     * @param v
     * @return
     */
    boolean havaPathTo(int v);

    /**
     * 从s 到 v的路径
     *
     * @param v
     * @return
     */
    Iterable<DirectedEdge> pathTo(int v);
}
