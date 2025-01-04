package chapter4.undirectedgraph.impl;

import chapter3.ST;
import chapter3.impl.LinearProbingHashST;
import chapter4.undirectedgraph.Graph;
import chapter4.undirectedgraph.SymbolGraph;
import edu.princeton.cs.algs4.In;

/**
 * @author bxwang
 * @date 2021/10/12 19:19
 */
public class SymbolGraphImpl extends SymbolGraph {

    /**
     * key: 顶点名
     * value: 索引
     */
    private ST<String, Integer> hash;

    /**
     * 索引 -> 符号名
     */
    private String[] keys;

    private Graph graph;

    public SymbolGraphImpl(String fileName, String delim) {
        hash = new LinearProbingHashST<>();
        In in = new In(fileName);

        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delim);

            for (String s : a) {
                if (!hash.contains(s)) {
                    hash.put(s, hash.size());
                }
            }
        }

        keys = new String[hash.size()];


        for (String name : hash.keys()) {
            keys[hash.get(name)] = name;
        }

        graph = new GraphImpl(hash.size());
        in = new In(fileName);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delim);
            int v = hash.get(a[0]);
            for (int i=1; i<a.length; i++) {
                graph.addEdge(v, hash.get(a[i]));
            }
        }
    }

    @Override
    public boolean contains(String key) {
        return hash.contains(key);
    }

    @Override
    public int index(String key) {
        return hash.get(key);
    }

    @Override
    public String name(int v) {
        return keys[v];
    }

    @Override
    public Graph graph() {
        return graph;
    }
}
