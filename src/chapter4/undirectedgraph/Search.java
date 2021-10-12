package chapter4.undirectedgraph;

/**
 * @author bxwang
 * @date 2021/10/12
 */
public abstract class Search {

    private Graph graph;
    private int source;

    /**
     * 找到和起点s联通的所有顶点
     * @param graph
     * @param source 图的起点
     */
    public Search(Graph graph, int source) {
        this.graph = graph;
        this.source = source;
    }


    /**
     * v 和 s是联通的么
     * 在图中从起点开始沿着路径到达其它顶点，并标记每个路过的顶点
     * @param v
     * @return
     */
    public abstract boolean marked(int v);

    /**
     * 与s联通的个数
     * @return
     */
    public abstract int count();
}
