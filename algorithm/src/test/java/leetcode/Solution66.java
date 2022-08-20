package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @aurhor Adam Wu
 * @date 2022-06-01 15:17:37
 */
public class Solution66 {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int carry = 1;
        for (int i = digits.length; i > 0; i--) {
            int val = digits[i - 1] + carry;
            if (val <= 9) {
                carry = 0;
            }

            list.add(val % 10);
        }
        if (carry == 1) {
            list.add(1);
        }

        int[] ans = new int[list.size()];
        for (int i = list.size() - 1, j = 0; i >= 0; i--, j++) {
            ans[j] = list.get(i);
        }
        return ans;
    }
}
