package chapter4.undirectedgraph;

import chapter4.undirectedgraph.impl.GraphImpl;

/**
 * @author bxwang
 * @date 2021/10/12 17:41
 */
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph graph) {
        marked = new boolean[graph.V()];
        for (int s=0; s<graph.V(); s++) {
            if (!marked[s]) {
                dfs(graph, s, s);
            }
        }
    }

    /**
     * u 是当前节点的parent节点
     * 如果是起始节点，那么为自己
     * @param graph
     * @param v
     * @param u
     */
    private void dfs(Graph graph, int v, int u) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w, v);
            } else if (w!=u) {
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        Graph graph = new GraphImpl(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        Cycle cycle = new Cycle(graph);

    }
}
