package leetcode;

/**
 * @author Adam Wu
 * @data 2022-05-24 16:49:54
 */
public class Solution13 {

    public int romanToInt(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char nc = i + 1 == s.length() ? 0 : s.charAt(i + 1);
            if (c == 'I' && nc == 'V') {
                ans += 4;
                i++;
            } else if (c == 'I' && nc == 'X') {
                ans += 9;
                i++;
            } else if (c == 'I') {
                ans += 1;
            }

            if (c == 'X' && nc == 'L') {
                ans += 40;
                i++;
            } else if (c == 'X' && nc == 'C') {
                ans += 90;
                i++;
            } else if (c == 'X') {
                ans += 10;
            }

            if (c == 'C' && nc == 'D') {
                ans += 400;
                i++;
            } else if (c == 'C' && nc == 'M') {
                ans += 900;
                i++;
            } else if (c == 'C') {
                ans += 100;
            }


            if (c == 'V') {
                ans += 5;
            }
            if (c == 'L') {
                ans += 50;
            }
            if (c == 'D') {
                ans += 500;
            }
            if (c == 'M') {
                ans += 1000;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        new Solution13().romanToInt("MCMXCIV");
    }
}
