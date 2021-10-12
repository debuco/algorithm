package chapter4.undirectedgraph;

/**
 * @author bxwang
 * @date 2021/10/12
 * 实现图的要求：
 * 1. 图必须为可能在应用中碰到的各种数据类型预留出足够的空间
 * 2. 图的实例方法的实现一定要快
 * 思考：
 *  ·邻接矩阵
 *      如果v、m之间有相邻的边，那么将矩阵的v m元素值设置为true
 *      · 违背要求1，当图所要求的的空间很大时，邻接矩阵的实现不符合要求
 *  ·边的数组
 *  ------------------------------------------------------------
 *  ·邻接数组
 *      类似于Hash
 *      ·使用一个以顶点为索引的列表数组，数组元素是和该顶点相邻的顶点列表
 *      ·数组元素的数据结构可以灵活变化
 */
public interface Graph {
    /**
     * @return 顶点数
     */
    int V();

    /**
     * @return 边数
     */
    int E();

    /**
     * 向图中添加一条 v-m 的边
     * @param v 顶点v
     * @param w 顶点w
     */
    void addEdge(int v, int w);

    /**
     * @param v 顶点
     * @return 和v相邻的所有顶点
     */
    Iterable<Integer> adj(int v);

}
