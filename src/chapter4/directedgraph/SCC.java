package chapter4.directedgraph;

/**
 * @author: bangxin.wang
 * @date: 2024/12/24 21:19
 */
public interface SCC {

    /**
     * v 和 w 是强连通的么
     *
     * @param v
     * @param w
     * @return
     */
    boolean stronglyConnected(int v, int w);

    /**
     * 图中强连通分量的总数
     *
     * @return
     */
    int count();

    /**
     * v 所在的强连通分量的索引
     *
     * @param v
     * @return
     */
    int id(int v);
}
