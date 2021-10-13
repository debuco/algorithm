package chapter4.directedgraph;

import chapter1.Queue;
import chapter1.Stack;

/**
 * @author bxwang(570463767 @ qq.com)
 * @date 2021/10/13 10:25
 */
public class DFSOrder  {

    private Digraph digraph;

    private boolean[] marked;

    /**
     * 所有顶点的前序队列
     */
    private Queue<Integer> pre;

    /**
     * 所有顶点的后序队列
     */
    private Queue<Integer> post;

    /**
     * 所有顶点的逆后序队列
     */
    private Stack<Integer> reversePost;

    public DFSOrder(Digraph digraph) {
        this.digraph = digraph;
        this.marked = new boolean[digraph.V()];

        for (int v = 0; v<digraph.V(); v++) {
            if (!marked[v]) {
                dfs(digraph, v);
            }
        }

    }

    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        pre.enqueue(v);

        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                dfs(digraph, w);
            }
        }

        post.enqueue(v);
        reversePost.push(v);

    }

    public Queue<Integer> getPre() {
        return pre;
    }

    public Queue<Integer> getPost() {
        return post;
    }

    public Stack<Integer> getReversePost() {
        return reversePost;
    }
}
