package chapter4.directedgraph;

/**
 * @author bxwang
 * @date 2021/10/12 20:23
 * 有向图中的可达性
 * 深度优先搜索
 * 1. 单点可达性
 * 2. 多点可达性
 */
public class DirectedDFS {

    private boolean[] marked;

    private Digraph digraph;
    private int source;
    private Iterable<Integer> sources;
    public DirectedDFS(Digraph digraph, int source) {
        this.digraph = digraph;
        this.source = source;

        this.marked = new boolean[digraph.V()];

        dfs(digraph, source);
    }

    public DirectedDFS(Digraph digraph, Iterable<Integer> sources) {
        this.digraph = digraph;
        this.sources = sources;

        this.marked = new boolean[digraph.V()];

        for (Integer s : sources) {
            dfs(digraph, s);
        }
    }


    private void dfs(Digraph digraph, int source) {
        marked[source] = true;

        for (int x : digraph.adj(source)) {
            if (!marked[x]) {
                dfs(digraph, x);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }


}
