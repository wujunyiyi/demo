package leetcode;

/**
 * @author Adam Wu
 * @date 2022-06-17 14:42:48
 */
public class Solution1089 {

    // 双指针。 反向赋值
    public void duplicateZeros(int[] arr) {
        int j = 0, i = 0;
        for (; i < arr.length; i++, j++) {
            if (arr[j] == 0) {
                i++;
            }
        }

        i--;
        j--;
        while (j >= 0) {
            if (i < arr.length) arr[i] = arr[j];
            if (arr[j] == 0 && --i >= 0) arr[i] = 0;

            i--;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] ints = {8, 4, 5, 0, 0, 0, 0, 7};
        new Solution1089().duplicateZeros(ints);
        System.out.println(ints);
    }
}
