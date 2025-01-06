package chapter4.directedgraph;

/**
 * ignore...
 * 有向图的强连通性
 *
 * @author: bangxin.wang
 * @date: 2024/12/24 21:39
 */
public class KosarajuSCC implements SCC {


    /**
     * 记录已访问的顶点
     */
    private boolean[] marked;
    /**
     * 强联通分量标识符
     */
    private int[] id;

    private int count;


    public KosarajuSCC(Digraph digraph) {
        this.marked = new boolean[digraph.V()];
        this.id = new int[digraph.V()];
        /**
         * 逆后续
         */
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph);
        for (int v : depthFirstOrder.reversePost()) {
            if (!marked[v]) {
                dfs(digraph, v);
                count++;
            }
        }
    }

    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                dfs(digraph, w);
            }
        }
    }


    @Override
    public boolean stronglyConnected(int v, int w) {
        return id[v] == id(w);
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
