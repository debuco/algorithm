package chapter4.undirectedgraph.impl;

import chapter1.Stack;
import chapter1.impl.stack.SinglyLinkedStack;
import chapter4.undirectedgraph.Graph;
import chapter4.undirectedgraph.Paths;

/**
 * @author bxwang
 * @date 2021/10/12 15:46
 *
 */
public class DepthFirstPaths extends Paths {
    /**
     * 该顶点上调用过dfs了么
     */
    private boolean[] marked;
    /**
     * 从起点到一个顶点的已知路径上的最后一个顶点
     * 理解该数据结构十分重要
     */
    private int[] edgeTo;

    public DepthFirstPaths(Graph graph, int source) {
        super(graph, source);
        edgeTo = new int[graph.V()];
        dfs(graph, source);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }

    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> path = new SinglyLinkedStack<>();
        for (int x = v; x!= getSource(); x = edgeTo[x]) {
            path.push(x);
        }
        path.push(getSource());

        return path;
    }
}
