package util;

/**
 * @author bxwang
 * @date 2021/9/28
 * @apiNote 一个标记校验类，具体的逻辑没有实现，只提供一些标记校验的方法
 */
public class CheckUtil {
    public static void checkCapacity() throws IllegalStateException{}

    public static void checkType() throws ClassCastException{}

    /**
     * @throws IllegalStateException 容量已满
     * @throws ClassCastException 类型不符合
     */
    public static void checkTypeAndCapacity() {
        checkType();
        checkCapacity();
    }
}
