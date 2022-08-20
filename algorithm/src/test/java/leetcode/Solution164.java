package leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Adam Wu
 * @date 2022-06-24 10:42:53
 */
public class Solution164 {

    // 桶排序
    public int maximumGap(int[] nums) {
        int len = nums.length, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        if (len < 2) {
            return 0;
        }
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        // *桶跨度
        int gap = (max - min) / len + 1;
        // *桶大小
        int bucketSize = (max - min) / gap + 1;

        // 初始化桶
        List<Integer>[] buckets = new List[bucketSize];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        // 入桶
        for (int num : nums) {
            buckets[(num - min) / gap].add(num);
        }

        int ans = 0, pre = -1;
        // 桶内排序， 并输出
        for (int i = 0, index = 0; i < buckets.length; i++) {
            Collections.sort(buckets[i]);

            for (Integer num : buckets[i]) {
                if (pre == -1) {
                    pre = num;
                } else {
                    ans = Math.max(ans, num - pre);
                    pre = num;
                }
            }
        }

        return ans;
    }

    // 桶排序算法
    void bucketSort(int[] nums) {
        /*
         * 桶排序就是将最大值和最小值之间的元素进行瓜分，设定某个桶的容量，然后再定义每个桶的跨度，然后根据元素的大小范围，将他们放入各自的桶中，再对每个桶进行排序，最后输出桶即排序完成
         *
         * 确定桶的跨度大小：int gap = (max - min) / array.length + 1;
         *
         * 就是范围除以个数就是每个里面有多少个了，比如100个苹果，分给5个人，每个人就20个，这个20就是gap跨度
         * 这个为什么要加1呢？因为如果8个苹果，分给8个人，则每人1个.而需要的桶的数量为(8-0)/1+1为9个，这样子就有点浪费空间了
         * 加上1的话，这样结果为(8-0)/2+1为5个，节省了空间
         * 确定桶的个数：int bucketNum = (max - min) / gap + 1;
         *
         * 就是范围除以每个有多少个，比如100个苹果，每个桶装20个，那么需要5个桶装，5就是bucketNum
         * 为什么要加1呢？如果有总的苹果树换成101个，那么如果每个桶转20个，就会还剩下1个，所以必须加1。加1作用是用来缓冲的，存储剩下的元素，他的跨度不确定
         */
        int len = nums.length, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        // *桶跨度
        int gap = (max - min) / len + 1;
        // *桶大小
        int bucketSize = (max - min) / gap + 1;

        // 初始化桶
        List<Integer>[] buckets = new List[bucketSize];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        // 入桶
        for (int num : nums) {
            buckets[(num - min) / gap].add(num);
        }

        // 桶内排序， 并输出
        for (int i = 0, index = 0; i < buckets.length; i++) {
            Collections.sort(buckets[i]);

            for (Integer num : buckets[i]) {
                nums[index++] = num;
            }
        }
    }
}
