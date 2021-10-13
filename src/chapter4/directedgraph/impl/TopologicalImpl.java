package chapter4.directedgraph.impl;

import chapter4.directedgraph.DFSOrder;
import chapter4.directedgraph.Digraph;
import chapter4.directedgraph.DirectedCycle;
import chapter4.directedgraph.Topological;

/**
 * @author bxwang(570463767 @ qq.com)
 * @date 2021/10/13 10:53
 */
public class TopologicalImpl implements Topological {

    private Digraph digraph;

    /**
     * 顶点的拓扑顺序
     */
    private Iterable<Integer> order;

    public TopologicalImpl(Digraph digraph) {
        DirectedCycle cycle = new DirectedCycle(digraph);

        if (!cycle.hasCycle()) {
            DFSOrder dfsOrder = new DFSOrder(digraph);

            order = dfsOrder.getReversePost();
        }
    }



    @Override
    public boolean isDAG() {
        return order == null;
    }

    @Override
    public Iterable<Integer> order() {
        return order;
    }
}
