package chapter4.undirectedgraph;

/**
 * @author bxwang
 * @date 2021/10/12
 *
 */
public abstract class SymbolGraph {

    public abstract boolean contains(String key);

    public abstract int index(String key);

    public abstract String name(int v);

    public abstract Graph graph();
}

