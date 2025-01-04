package chapter4.undirectedgraph;

/**
 * @author bxwang
 * @date 2021/10/12 15:36
 */
public abstract class Paths {
    private Graph graph;
    private int source;

    public Paths(Graph graph, int source) {
        this.graph = graph;
        this.source = source;
    }

    /**
     * v has source to source
     *
     * @param v
     * @return
     */
    public abstract boolean hasPathTo(int v);

    public abstract Iterable<Integer> pathTo(int v);

    protected int getSource() {
        return source;
    }
}
