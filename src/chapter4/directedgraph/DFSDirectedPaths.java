package chapter4.directedgraph;

import chapter1.Stack;
import chapter1.impl.stack.SinglyLinkedStack;

/**
 * @author bxwang
 * @date 2021/10/12 20:45
 * 单点有向路径，问题：给定一副有向图和一个起点s，回答，从s到给定目标顶点v是否存在一条有向路径？如果有，找出这条路径
 */
public class DFSDirectedPaths {
    private Digraph digraph;
    private int source;
    private boolean[] marked;
    private int[] edgeTo;
    public DFSDirectedPaths(Digraph digraph, int source) {
        this.digraph = digraph;
        this.source = source;
        this.marked = new boolean[digraph.V()];
        this.edgeTo = new int[digraph.V()];
        dfs(digraph, source);
    }

    private void dfs(Digraph digraph, int source) {
        marked[source] = true;
        for (int x : digraph.adj(source)) {
            if (!marked[x]) {
                // 索引是to， 内容是到该节点的最后一个节点， 反向指向source
                edgeTo[x] = source;
                dfs(digraph, x);
            }
        }
    }


    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> stack = new SinglyLinkedStack<>();
        for (int x=v; x!=source; x=edgeTo[x]) {
            stack.push(x);
        }
        stack.push(source);
        return stack;
    }
}
