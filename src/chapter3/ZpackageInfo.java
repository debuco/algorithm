/**
 * @author bxwang
 * @date 2-21/9/29 21:45
 * 查找算法
 * 符号表或字典来描述一张表格，表格中包含的信息(值)按照键来获取
 * ·键
 * ·值
 * 针对这样一张表格，要实现高效的插入和查找
 *
 * 约定
 * 1. 重复的键（思考？键与键之间如何比较）
 *  每个键只对应一个值，即字典中不允许存在重复的键
 *  插入已存在的键，新的值将替换旧值
 * 2. 空键
 *  键不能为空，使用空键将抛出异常
 * 3. 空值
 *  不允许存在空值
 * 4. 删除
 *  ·延时删除
 *      将键对应的值置空，在某个时候删除所有值为空的键
 *  ·即时删除
 *      立即从表中删除指定的键
 * 5. 迭代
 *
 * 6. 键的等价性
 *  一个好的实践：所有{@link java.lang.Comparable}类型要维护compareTo()方法和equals()方法的一致性
 *  该包中使用compareTo()方法判别键的等价性
 *
 * 代码清单：
 * 1. 字典的数据抽象{@link chapter3.ST}
 * 2. 排序字典数据抽象{@link chapter3.SortedST}
 * 3. 基于单链表的字典实现{@link chapter3.impl.SequentialSearchST}
 * 4. 基于平行数组的字典实现{@link chapter3.impl.BinarySearchST}
 */
package chapter3;