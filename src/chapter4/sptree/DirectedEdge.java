package chapter4.sptree;

/**
 * @author: bangxin.wang\
 * @date: 2025/1/6 15:49
 */
public interface DirectedEdge {
    /**
     * 边的权重
     *
     * @return
     */
    double weight();

    /**
     * 边的起点
     *
     * @return
     */
    int from();

    /**
     * 边指向的点
     *
     * @return
     */
    int to();
}
