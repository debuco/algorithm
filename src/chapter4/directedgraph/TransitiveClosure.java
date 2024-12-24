package chapter4.directedgraph;

/**
 * @author: bangxin.wang
 * @date: 2024/12/24 22:26
 */
public class TransitiveClosure {
    private DirectedDFS[] all;

    public TransitiveClosure(Digraph digraph) {
        this.all = new DirectedDFS[digraph.V()];
        for (int v = 0; v < digraph.V(); v++) {
            all[v] = new DirectedDFS(digraph, v);
        }
    }

    /**
     * w 由 v 是否可达
     * @param v
     * @param w
     * @return
     */
    public boolean reachable(int v, int w) {
        return all[v].marked(w);
    }
}
