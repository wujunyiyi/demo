package leetcode;


/**
 * @aurhor Adam Wu
 * @date 2022-06-07 13:09:47
 */
public class Solution875 {
    public int minEatingSpeed(int[] piles, int h) {
        int ls = 1, hs = 0;
        for (int pile : piles) {
            if (pile > hs)
                hs = pile;
        }

        if (h == piles.length) {
            return hs;
        }

        int k = hs;
        while (ls < hs) {
            int s = ls + (hs - ls) / 2;

            int time = 0;
            for (int pile : piles) {
                // 向上取整
                time += (pile + s - 1) / s;
                // time += (int) Math.ceil(((double) pile) / s);
            }

            if (time > h) {
                ls = s + 1;
            } else {
                hs = s;
                k = s;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int i = new Solution875().minEatingSpeed(new int[]{2, 2}, 3);
        System.out.println(i);
    }

}
