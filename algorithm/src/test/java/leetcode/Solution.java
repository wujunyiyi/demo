package leetcode;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: Adam
 * @create: 2022/05/11 16:03
 */
public class Solution {

    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        out:
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    break out;
                }
            }
        }
        return result;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            Integer j = map.get(target - nums[i]);
            if (j != null) {
                result[0] = i;
                result[1] = j;
            }

            map.put(nums[i], i);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
