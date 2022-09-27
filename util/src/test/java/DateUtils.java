import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

/**
 * @author junyi.wu
 * @date 2022/9/9
 */
public class DateUtils {

    @Test
    public void test(){
        LocalDateTime dateTime = LocalDateTime.now().withYear(2021);
    }
}
