package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adam Wu
 * @date 2022-07-05 13:46:07
 */
public class MyCalendar729 {
    List<int[]> booked = new ArrayList<>();

    public MyCalendar729() {
    }

    public boolean book(int start, int end) {
        for (int[] books : booked) {
            int l = books[0], r = books[1];

            if (start < r && end > l) {
                return false;
            }
        }
        booked.add(new int[]{start, end});
        return true;
    }
}
