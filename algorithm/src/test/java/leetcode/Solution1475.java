package leetcode;

import java.util.Stack;

/**
 * @author junyi.wu
 * @date 2022/9/1
 */
public class Solution1475 {

    //  TODO 单调栈解法
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
//            while (!stack.isEmpty() &&)

            stack.push(prices[i]);
        }

        return prices;
    }

    // 暴力解法
    public int[] finalPrices1(int[] prices) {
        int[] ans = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int dis = 0, cur = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= cur) {
                    dis = prices[j];
                    break;
                }
            }

            ans[i] = cur - dis;
        }

        return ans;
    }
}
