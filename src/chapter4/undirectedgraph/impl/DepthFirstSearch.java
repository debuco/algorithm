package chapter4.undirectedgraph.impl;

import chapter4.undirectedgraph.Graph;
import chapter4.undirectedgraph.Search;

/**
 * @author bxwang
 * @date 2021/10/12 15:18
 * 1. 沿着图的边从一个顶点移动到另一个顶点
 *
 *
 */
public class DepthFirstSearch extends Search {
    /**
     * 记录标记过的顶点
     */
    private boolean[] marked;
    private int count;
    public DepthFirstSearch(Graph graph, int source) {
        super(graph, source);
        marked = new boolean[graph.V()];
        dfs(graph, source);
    }

    /**
     * 1. 将顶点标记为已访问
     * 2. 递归的访问它的所有没有被标记过的邻居顶点
     * @param graph
     * @param v
     */
    private void dfs(Graph graph, int v) {
        marked[v] = true;
        count++;
        for (int w : graph.adj(v)) {
            if (!marked(w)) {
                dfs(graph, w);
            }
        }
    }

    @Override
    public boolean marked(int v) {
        return marked[v];
    }

    @Override
    public int count() {
        return count;
    }
}
