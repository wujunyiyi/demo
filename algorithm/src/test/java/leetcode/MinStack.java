package leetcode;

import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * 实现 MinStack 类:
 * <p>
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *  
 * <p>
 * 提示：
 * <p>
 * -231 <= val <= 231 - 1
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 * push, pop, top, and getMin最多被调用 3 * 104 次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Adam Wu
 * @date 2022-06-16 13:50:50
 */
public class MinStack {
    // 辅助栈
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    int min = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        min = Math.min(val, min);
        minStack.push(min);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
            min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
