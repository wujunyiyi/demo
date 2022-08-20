package leetcode;

/**
 * @author Adam Wu
 * @date 2022-06-21 10:22:30
 */
public class Solution1108 {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
