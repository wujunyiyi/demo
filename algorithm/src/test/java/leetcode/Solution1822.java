package leetcode;

/**
 * @author junyi.wu
 * @date 2022/10/27
 */
public class Solution1822 {

    public int arraySign(int[] nums) {
        int sign = 1;
        for (int num : nums) {
            if(num == 0) return 0;
            if(num < 0) sign *= -1;
        }

        return sign;
    }
}
