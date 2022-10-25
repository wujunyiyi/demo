import java.math.BigDecimal;
import java.util.Locale;

import org.apache.commons.lang3.LocaleUtils;
import org.junit.Test;


/**
 * @author junyi.wu
 * @date 2022/9/29
 */
public class LocalUtil {
    @Test
    public void test() {
        Locale zh_cn = LocaleUtils.toLocale("ja_pn");
        System.out.println(zh_cn);
    }

    @Test
    public void test1() {
        BigDecimal bigDecimal = new BigDecimal(1);
        BigDecimal ans = bigDecimal.add(new BigDecimal(-1));
        System.out.println(bigDecimal);
        System.out.println(ans);
        System.out.println(bigDecimal.negate());
    }

    @Test
    public void test2t(){
        System.out.println(System.getenv("hostname"));
    }
}
