package chapter4.directedgraph;

import chapter1.Queue;
import chapter1.Stack;
import chapter1.impl.queue.SinglyLinkedQueue;
import chapter1.impl.stack.SinglyLinkedStack;
import chapter4.directedgraph.impl.DigraphImpl;

/**
 * @author: bangxin.wang
 * @date: 2024/12/23 15:16
 */
public class DepthFirstOrder {
    private boolean[] marked;
    // 所有顶点的前序排列
    private Queue<Integer> pre;
    // 所有顶点的后序排列
    private Queue<Integer> post;
    // 所有顶点的逆后序排列
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph G) {
        pre = new SinglyLinkedQueue<>();
        post = new SinglyLinkedQueue<>();
        reversePost = new SinglyLinkedStack<>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        pre.enqueue(v);
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }

    public static void main(String[] args) {
        Digraph digraph = new DigraphImpl(13);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 5);
        digraph.addEdge(0, 6);
        digraph.addEdge(2, 0);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 5);
        digraph.addEdge(5, 4);
        digraph.addEdge(6, 4);
        digraph.addEdge(6, 9);
        digraph.addEdge(7, 6);
        digraph.addEdge(8, 7);
        digraph.addEdge(9, 10);
        digraph.addEdge(9, 11);
        digraph.addEdge(9, 12);
        digraph.addEdge(11, 12);

        DepthFirstOrder order = new DepthFirstOrder(digraph);
        System.out.println(order.pre());
        System.out.println(order.post());
        System.out.println(order.reversePost());


    }
}