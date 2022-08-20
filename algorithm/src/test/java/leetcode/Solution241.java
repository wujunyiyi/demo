package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adam Wu
 * @date 2022-07-01 15:42:04
 */
public class Solution241 {

    public List<Integer> diffWaysToCompute(String expression) {
        char[] cs = expression.toCharArray();
        return dfs(cs, 0, cs.length - 1);
    }

    List<Integer> dfs(char[] cs, int l, int r) {
        List<Integer> ans = new ArrayList<>();

        for (int i = l; i < r; i++) {
            if (cs[i] >= '0' && cs[i] <= '9') continue;

            List<Integer> la = dfs(cs, l, i - 1), ra = dfs(cs, i + 1, r);
            for (Integer a : la) {
                for (Integer b : ra) {
                    int val = compute(a, b, cs[i]);
                    ans.add(val);
                }
            }
        }

        // 递归的出栈， 没有符号位时
        if (ans.isEmpty()) {
            ans.add(Integer.valueOf(String.valueOf(cs, l, r - l + 1)));
        }

        return ans;
    }

    int compute(int a, int b, char operational) {
        switch (operational) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }

        return 0;
    }

    public static void main(String[] args) {
        new Solution241().diffWaysToCompute("11");
    }
}
