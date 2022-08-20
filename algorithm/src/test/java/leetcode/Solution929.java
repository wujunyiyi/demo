package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @aurhor Adam Wu
 * @date 2022-06-06 16:29:21
 */
public class Solution929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String[] split = email.split("@");
            set.add(split[0].replace(".", "").split("\\+")[0] + "@" + split[1]);
        }

        return set.size();
    }

}
