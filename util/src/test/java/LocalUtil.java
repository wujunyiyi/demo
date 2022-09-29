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
}
