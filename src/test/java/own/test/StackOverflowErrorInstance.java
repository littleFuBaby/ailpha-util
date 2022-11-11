package own.test;
/**
 * 栈溢出错误示例
 * @author andy
 */
public class StackOverflowErrorInstance {
    /**
     * 递归方法
     * @param x
     * @return
     */
    public static int recurse(int x) {
        // 具有访问出口，符合正确递归调用方法理念
        if (x >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return recurse(x++);
    }
    public static void main(String[] args) {
        recurse(Integer.MIN_VALUE);
    }
}
