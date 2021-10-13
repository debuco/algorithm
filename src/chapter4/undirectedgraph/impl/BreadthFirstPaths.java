package chapter4.undirectedgraph.impl;

import chapter1.Queue;
import chapter1.Stack;
import chapter1.impl.queue.SinglyLinkedQueue;
import chapter1.impl.stack.SinglyLinkedStack;
import chapter4.undirectedgraph.Graph;
import chapter4.undirectedgraph.Paths;

/**
 * @author bxwang
 * @date 2021/10/12 16:48
 * 要找到source到v的最短路径
 * 1. 从source开始在所有由一条边可以到达的顶点中寻找v
 *      ·如果找不到，在所有与source距离两条边的顶点中寻找v，如此一致进行，直到找到v
 * 实现：
 *      在一幅图中需要搜索多条边时，会选择其中一条并将其它通道留到以后继续搜索：使用一个队列（FIFO），
 *      保存所有已经标记过但其邻接表还未被遍历过的顶点，先将顶点加入队列，然后重复以下步骤直到队列为空
 *      · 取队列中的下一个顶点v并标记它
 *      · 将于v相邻的所有未标记过的顶点加入队列
 */
public class BreadthFirstPaths extends Paths {
    /**
     * 到达该顶点的最短路径已知么
     */
    private boolean[] marked;
    /**
     * 到达该顶点的已知路径上的最后一个顶点
     */
    private int[] edgeTo;

    public BreadthFirstPaths(Graph graph, int source) {
        super(graph, source);
        marked = new boolean[graph.V()];
        bfs(graph, source);
    }

    private void bfs(Graph graph, int source) {
        Queue<Integer> queue = new SinglyLinkedQueue<>();
        marked[source] = true;
        queue.enqueue(source);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }
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

        Stack<Integer> stack = new SinglyLinkedStack<>();
        for (int x = v; x != getSource(); x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(getSource());

        return stack;
    }
}
