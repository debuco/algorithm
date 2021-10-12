package chapter4.undirectedgraph;

/**
 * @author bxwang
 * @date 2021/10/12 17:13
 *
 */
public abstract class CC {

    private Graph graph;

    public CC(Graph graph) {
        this.graph = graph;
    }

    /**
     * v 和 m 联通么
     * @param v
     * @param w
     * @return
     */
    public abstract boolean connected(int v, int w);

    /**
     * 联通分量数
     * @return
     */
    public abstract int count();

    /**
     * v 所在的联通分量的标识符
     * @param v
     * @return
     */
    public abstract int id(int v);
}
