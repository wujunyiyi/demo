package leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * todo
 *
 * @author Adam Wu
 * @data 2022-05-24 14:51:35
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        for (int i = 0, l = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                l = map.get(c);
            }

            map.put(c, i);
            max = Math.max(max, i - l);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("dvdf"));
    }
}
