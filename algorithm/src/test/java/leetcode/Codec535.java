package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Adam Wu
 * @date 2022-06-29 13:20:26
 */
public class Codec535 {
    Map<String, String> map = new HashMap<>();
    int k = 6;
    String pool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Random random = new Random();
    String prefix = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = map.get(longUrl);
        while (shortUrl == null) {
            StringBuffer sb = new StringBuffer();
            sb.append(prefix);

            for (int i = 0; i < k; i++)
                sb.append(pool.charAt(random.nextInt(pool.length())));

            String su = sb.toString();
            if (map.containsKey(su)) continue;

            shortUrl = su;
            map.put(shortUrl, longUrl);
        }

        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

    public static void main(String[] args) {
        Codec535 code = new Codec535();
        String shortUrl = code.encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println(shortUrl);
        System.out.println(code.decode(shortUrl));
    }
}
