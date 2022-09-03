package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author junyi.wu
 * @date 2022/9/3
 */
public class Solution646 {
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, Comparator.comparingInt(p -> p[1]));

        int c = Integer.MIN_VALUE, ans = 0;
        for (int i = 0; i < pairs.length; i++) {
            if(c < pairs[i][0]){
                c = pairs[i][1];
                ans++;
            }
        }

        return ans;
    }
}
