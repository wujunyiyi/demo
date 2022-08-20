package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: Adam
 * @create: 2022/05/18 17:04
 */
public class Solution378 {
    class Head implements Comparable<Head> {
        int val;
        int x;
        int y;

        public Head(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Head o) {
            return this.val - o.val;
        }
    }

    // TODO 归并法
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Head> queue = new PriorityQueue<>();

        for (int i = 0; i < matrix.length; i++) {
            queue.offer(new Head(matrix[i][0], 0, i));
        }

        while (!queue.isEmpty()) {
            Head poll = queue.poll();
            if (--k == 0) {
                return poll.val;
            }

            if (poll.x + 1 < matrix[poll.y].length) {
                queue.offer(new Head(matrix[poll.y][poll.x + 1], poll.x + 1, poll.y));
            }
        }

        return -1;
    }

    // 二分法 同668题
    public int kthSmallest1(int[][] matrix, int k) {
        int l = matrix[0][0], r = matrix[matrix.length - 1][(matrix[matrix.length - 1]).length - 1];
        while (l < r) {
            int mid = l + (r - l) / 2;

            int count = 0;
            int i = matrix.length - 1;
            int j = 0;
            while (i >= 0 && j < (matrix[i]).length) {
                if (matrix[i][j] <= mid) {
                    count += i + 1;
                    j++;
                } else {
                    i--;
                }
            }

            if (count < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(new Solution378().kthSmallest(matrix, 8));
    }
}
