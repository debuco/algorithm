package chapter4.directedgraph;

import chapter1.Stack;
import chapter1.impl.stack.SinglyLinkedStack;
import chapter4.directedgraph.impl.DigraphImpl;

/**
 * @author bxwang(570463767 @ qq.com)
 * @date 2021/10/12 21:46
 */
public class DirectedCycle {

    private boolean[] marked;

    private int[] edgeTo;

    /**
     * 有向图中的所有顶点
     */
    private Stack<Integer> cycle;

    /**
     * 递归调用的栈上的所有顶点
     */
    private boolean[] onStack;


    private Digraph digraph;

    public DirectedCycle(Digraph digraph) {
        this.digraph = digraph;
        this.marked = new boolean[digraph.V()];
        this.edgeTo = new int[digraph.V()];
        this.onStack = new boolean[digraph.V()];
        for (int v = 0; v < digraph.V(); v++) {
            if (!marked[v]) {
                dfs(digraph, v);
            }
        }
    }

    private void dfs(Digraph digraph, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : digraph.adj(v)) {
            if (this.hasCycle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(digraph, w);
            } else if (onStack[w]) {
                cycle = new SinglyLinkedStack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                // 实际上这里再将自己添加进去是为了让检测到的点出现两次，出现两次则肯定为环
                cycle.push(v);
            }
        }
        // 弹出
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
