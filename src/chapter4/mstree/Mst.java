package chapter4.mstree;

/**
 * @author: bangxin.wang
 * @date: 2024/12/24 14:42
 */
public interface Mst {

    /**
     * 最小生成树的所有边
     * @return
     */
    Iterable<Edge> edges();
    /**
     * 最小生成树的权重
     *
     * @return
     */
    double weight();
}

