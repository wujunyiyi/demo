package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: Adam
 * @create: 2022/05/12 09:33
 */
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, (i1, i2) -> i1[0] == i2[0] ? i1[1] - i2[1] : i1[0] - i2[0]);

        List<int[]> merge = new ArrayList<>();
        merge.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int l = intervals[i][0], r = intervals[i][1];

            int[] array = merge.get(merge.size() - 1);
            if (array[1] >= l) {
                array[1] = Math.max(array[1], r);
            } else {
                merge.add(intervals[i]);
            }
        }

        return merge.toArray(new int[merge.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        new Solution56().merge(intervals);
    }
}
