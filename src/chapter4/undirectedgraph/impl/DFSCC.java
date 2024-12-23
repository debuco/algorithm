package chapter4.undirectedgraph.impl;

import chapter4.undirectedgraph.CC;
import chapter4.undirectedgraph.Graph;

/**
 * @author bxwang
 * @date 2021/10/12 17:24
 */
public class DFSCC extends CC {
    /**
     * 标记 一个顶点作为每个联通分量中的起点
     */
    private boolean[] marked;

    /**
     * 以顶点作为索引的数组
     * 将同一个联通分量中的顶点和联通分量的标识符关联起来
     */
    private int[] id;

    /**
     * 表示联通分量的数量
     */
    private int count;

    public DFSCC(Graph graph) {
        super(graph);
        marked = new boolean[graph.V()];
        id = new int[graph.V()];
        for (int s = 0; s < graph.V(); s++) {
            if (!marked[s]) {
                dfs(graph, s);
                count ++;
            }
        }

    }

    private void dfs(Graph graph, int s) {
        marked[s] = true;
        id[s] = count;
        for (int x : graph.adj(s)) {
            if (!marked[x]) {
                dfs(graph, s);
            }
        }
    }

    @Override
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public int id(int v) {
        return id[v];
    }
}
