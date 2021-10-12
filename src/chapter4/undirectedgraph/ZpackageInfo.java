/**
 * @author bxwang
 * @date 2021/10/12
 * 重要概念：
 * 图是由一组顶点和一组能够将两个顶点相连的边组成的
 * ·边(edge)
 * ·顶点(vertex)
 * 1. 自环---边
 *  一条连接一个顶点和顶点自身的边
 * 2. 平行边
 *  连接同一对顶点的两条边
 * 3. 相邻---顶点， 依附---边
 *  当两个顶点通过一条边相连时，这两个顶点是相邻的，并称这条边依附于中两个顶点
 * 4. 度数---顶点
 *  某个顶点的度数为依附于它的边的总数
 * 5. 子图
 *  子图是一幅图的所有边的一个子集组成的图
 * 6. 路径
 *  路径是由边顺序连接的一系列顶点
 * 7. 简单路径
 *  一条没有重复顶点的路径
 * 8. 环
 *  一条至少含有一条边且起点和终点相同的路径
 * 9. 简单环
 *  一条除了起点和终点必须相同，不包含重复顶点和边的环
 * 10. 路径和环的长度
 * 其中所包含的边数
 * 11. 顶点间的联通
 *  当两个顶点间存在一条连接双方的路径，一个顶点和一个顶点是联通的
 * 12. 连通图
 *  如果从任意一个顶点都存在一条路径到达另一个顶点，那么该图是联通图
 * 13. 非联通图
 *  一条非连通图由若干连通的部分组成，他们都是其极大联通子图
 * 14. 无环图
 *  无环图是一种不包含环的图
 * 15. 树
 *  是一副五环连通图
 * 16. 森林
 *  互不相连的树组成的集合称为森林
 * 17. 图的密度
 * 18. 二分图
 *
 *
 * 代码清单：
 * 0. 图的使用案例：{@link chapter4.undirectedgraph.GraphClient}
 * 1. 无向图的接口定义：{@link chapter4.undirectedgraph.Graph}
 * 2. 无向图的实现：{@link chapter4.undirectedgraph.graphimpl.GraphImpl}
 * 3. 深度优先搜索
 *    ·两个给定的顶点是否连通？
 *      ·图的搜索API：{@link chapter4.undirectedgraph.Search}
 *      ·深度优先搜索连通性：代码：{@link chapter4.undirectedgraph.graphimpl.DepthFirstSearch}
 *    ·给定一幅图和一个起点s，从s到v是否存在一条路径，如果有找出这条路径
 *      ·接口定义：{@link chapter4.undirectedgraph.Paths}
 *      ·深度优先搜索路径：{@link chapter4.undirectedgraph.graphimpl.DepthFirstPaths}
 * 4. 广度优先搜索
 *    深度优先搜索搜索到的路径取决于图的结构，图的调用和递归调用的性质
 *    ·单点最短路径
 *      给定一幅图和一个起点source，回答从source到给定目标顶点v是否存在一条路径？如果有找到其中最短的那条。
 */
package chapter4.undirectedgraph;
