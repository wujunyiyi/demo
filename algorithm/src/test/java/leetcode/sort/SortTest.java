package leetcode.sort;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Adam Wu
 * @date 2022-06-24 11:43:01
 */
public class SortTest {
    // 计数排序
    // 只针对正整数
    void countSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums)
            max = Math.max(max, num);

        int[] arr = new int[max + 1];
        for (int num : nums) {
            arr[num]++;
        }

        for (int i = 0, j = 0; i < arr.length; i++) {
            int count = arr[i];
            while (count > 0) {
                nums[j++] = i;
                count--;
            }
        }
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

    //region 冒泡排序
    void bubbleSort(int[] nums) {
        for (int i = nums.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                }
            }
        }
    }
    //endregion

    //region 插入排序
    void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }
    //endregion

    //region 选择排序
    void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            int index = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[index] > nums[j]) {
                    index = j;
                }
            }

            if (index != i)
                swap(nums, i, index);
        }
    }
    //endregion

    //region 快速排序
    void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    void quickSort(int[] nums, int start, int end) {
        if (start == end) return;

        int num = nums[end], l = start, r = end - 1;
        while (l < r) {
            while (nums[l] <= num && l < r) l++;
            while (nums[r] >= num && l < r) r--;
            if (l < r)
                swap(nums, l, r);
        }

        if (nums[l] > num) swap(nums, l, end);

        quickSort(nums, start, l);
        quickSort(nums, l + 1, end);
    }
    //endregion

    // 堆排序
    void heapSort(int[] num) {

    }

    // 归并排序
    void mergeSort(int[] nums) {

    }

    // 希尔排序
    void shellSort(int[] nums) {

    }

    // 基数排序 TODO
    void radixSort(int[] nums) {
        int high = 0;
        for (int num : nums) {

            int h = 0;
            if (num == 0) {
                h = 1;
            } else {
                for (int i = num; i != 0; i = i / 10) {
                    h++;
                }
            }

            high = Math.max(high, h);
        }

        for (int k = 1; k <= high; k++) {

        }
    }

    void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 1, 1, 2, 10, 11, 2, 3, 245, 1, 23, 4, 6, 2, 1, 33, 45, 6, 231, 4, 5, 2, 23, 234, 23, 8};
        new SortTest().quickSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
