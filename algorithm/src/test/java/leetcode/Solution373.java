package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Adam Wu
 * @data 2022-05-23 15:15:51
 */
public class Solution373 {
    // 归并
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, Comparator.comparingInt(i -> (nums1[i[0]] + nums2[i[1]])));

        for (int i = 0; i < nums1.length; i++) {
            queue.offer(new int[]{i, 0});
        }

        List<List<Integer>> res = new ArrayList<>();
        while (k-- > 0 && !queue.isEmpty()) {
            int[] poll = queue.poll();
            int l = poll[0], r = poll[1];
            res.add(new ArrayList<Integer>() {
                {
                    add(nums1[l]);
                    add(nums2[r]);
                }
            });

            if (r + 1 < nums2.length) {
                queue.offer(new int[]{l, r + 1});
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution373().kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3);
        System.out.println(lists);
    }
}
