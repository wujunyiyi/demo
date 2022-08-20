package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Adam Wu
 * @date 2022-06-23 17:18:04
 */
public class Solution30 {

    // hash表+暴力枚举
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length, wl = words[0].length(), slen = n * wl;

        Map<String, Integer> nmap = new HashMap<>();
        for (String word : words) {
            nmap.put(word, nmap.getOrDefault(word, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i + slen <= s.length(); i++) {

            Map<String, Integer> cmap = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String sub = s.substring(i + (j * wl), i+((j + 1) * wl));
                if (!nmap.containsKey(sub)) break;
                cmap.put(sub, cmap.getOrDefault(sub, 0) + 1);
            }

            if (cmap.equals(nmap)) ans.add(i);
        }

        return ans;
    }
}
