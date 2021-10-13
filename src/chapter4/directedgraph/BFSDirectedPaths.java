package chapter4.directedgraph;

import chapter1.Queue;
import chapter1.Stack;
import chapter1.impl.queue.SinglyLinkedQueue;
import chapter1.impl.stack.SinglyLinkedStack;

/**
 * @author bxwang
 * @date 2021/10/12 21:16
 *  单点最短路径，问题：给定一副有向图和一个起点s，回答，从s到给定目标顶点v是否存在一条有向路径？如果有，找出最短的那条。
 */
public class BFSDirectedPaths {

    private boolean[] marked;
    private int[] edgeTo;

    private Digraph digraph;
    private int source;
    public BFSDirectedPaths(Digraph digraph, int source) {
        this.digraph = digraph;
        this.source = source;
        this.marked = new boolean[digraph.V()];
        this.edgeTo = new int[digraph.V()];
        dfs(digraph, source);
    }

    private void dfs(Digraph digraph, int source) {
        Queue<Integer> queue = new SinglyLinkedQueue<>();
        queue.enqueue(source);
        marked[source] = true;
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int x : digraph.adj(v)) {
                edgeTo[x] = source;
                marked[x] = true;
                queue.enqueue(x);
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
