/**
 * @author bxwang
 * @date 2021/10/12 16:39
 * 概念：
 * 在有向图中，边时单向的：每条边所连接的两个顶点是一个有序对，它们的邻接性是单向的。
 * 一副有方向的图，由一组顶点和一组有方向的边组成的，每条有方向的边都连接着有序的一对顶点。
 * · 方向
 * · 顶点的有序性
 * 1. 出度和入度
 * 2. 有向边的头和尾
 * 3. 可达性
 *
 * 代码清单：
 * 1. 有向图接口定义：{@link chapter4.directedgraph.Digraph}
 * 2. 有向图接口实现：{@link chapter4.directedgraph.impl.DigraphImpl}
 * 3. 有向图可达性：
 *    问题： 给定一幅图和一个起点s，回答是否存在一条从s到给定顶点v 的有向路径？
 *    深度优先搜索实现：{@link chapter4.directedgraph.DirectedDFS}
 * 4. 有向图的寻址
 *    · 单点有向路径，问题：给定一副有向图和一个起点s，回答，从s到给定目标顶点v是否存在一条有向路径？如果有，找出这条路径。
 *      深度优先搜索实现：{@link chapter4.directedgraph.DFSDirectedPaths}
 *    · 单点最短路径，问题：给定一副有向图和一个起点s，回答，从s到给定目标顶点v是否存在一条有向路径？如果有，找出最短的那条。
 *      广度优先搜索实现：{@link chapter4.directedgraph.BFSDirectedPaths}
 * 5. 寻找有向环
 *    深度优先遍历实现：{@link chapter4.directedgraph.DirectedCycle}
 * 6. 拓扑排序
 *    拓扑接口定义：{@link chapter4.directedgraph.Topological}
 *
 */
package chapter4.directedgraph;
