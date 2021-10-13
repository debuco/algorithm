package chapter4.directedgraph;

/**
 * @author bxwang
 * @date 2021/10/12 19:51
 *
 */
public abstract class Digraph {
    private int v;

    /**
     * @param v 顶点的总数
     */
    public Digraph(int v) {
        this.v = v;
    }

    /**
     * 顶点的总数
     */
    public int V() {
        return v;
    }

    /**
     * @return 边的个数
     */
    public abstract int E();


    /**
     * 添加一条由v指向w的边
     * @param v
     * @param w
     */
    public abstract void addEdge(int v, int w);

    /**
     *
     * @param v
     * @return 由v指出的边所连接的所有顶点
     */
    public abstract Iterable<Integer> adj(int v);


    /**
     * @return 该图的反向图
     */
    public abstract Digraph reverse();

}
