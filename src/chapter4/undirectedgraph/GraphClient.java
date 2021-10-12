package chapter4.undirectedgraph;

/**
 * @author bxwang
 * @date 2021/10/12
 * 常用的图处理代码
 */
public class GraphClient {

    /**
     * 图中顶点v的度数
     * @param graph 传入的图
     * @param v 图中顶点
     */
    public static int degree(Graph graph, int v) {
        int degree = 0;
        for (int w : graph.adj(v)) {
            degree ++;
        }
        return degree;
    }

    /**
     * 计算所有顶点的最大度数
     */
    public static int maxDegree(Graph graph) {
        int max = 0;
        for (int v = 0; v < graph.V(); v++) {
            int degree = degree(graph, v);
            if (degree > max) {
                max = degree;
            }
        }
        return max;
    }

    /**
     * 计算所有顶点的平均度数
     */
    public static double avgDegree(Graph graph) {
        return 2.0 * graph.E() / graph.V();
    }

    /**
     * 计算图中自环的个数
     * @param graph
     * @return
     */
    public static int numberOfSelfLoops(Graph graph) {
        int count = 0;
        for (int v = 0; v < graph.V(); v++) {
            for (int m : graph.adj(v)) {
                if (v == m) {
                    count ++;
                }
            }
        }
        return count/2;
    }

}
