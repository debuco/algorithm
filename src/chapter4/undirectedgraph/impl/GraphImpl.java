package chapter4.undirectedgraph.impl;

import chapter1.Bag;
import chapter1.impl.bag.SinglyLinkedBag;
import chapter4.undirectedgraph.Graph;
import edu.princeton.cs.algs4.In;

/**
 * @author bxwang
 * @date 2021/10/12
 * 邻接表数组是一个非常重要的概念：
 *
 * · 以顶点为索引的列表数组
 *      · 使用的空间和(V+E)成正比
 *      · 添加一条边所需要的时间为常数
 *      · 遍历顶点v的所有相邻点所需要的时间和v的度数成正比
 * · 边的插入顺序决定了Graph邻接表中顶点的出现顺序
 *
 */
public class GraphImpl implements Graph {
    // 顶点数目
    private final int V;
    // 边的数目
    private int E;

    /**
     * 这块的数据结构可以更换
     */
    private Bag<Integer>[] adj;

    public GraphImpl(int V) {
        this.V = V;
        this.E = 0;
        adj = new SinglyLinkedBag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new SinglyLinkedBag<>();
        }
    }


    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }



    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
