import com.zigcag.rbac.model.User;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: zhengchang
 * @Date: 2020/9/7
 */
public class SimpleTest {
    @Test
    public void testAdd() {
        boolean b = Pattern.matches("^1[3456789]\\d{9}$", "18811158945");
        boolean b2 = Pattern.matches("^1[3456789]\\d{9}$", "188111589453");
        boolean b3 = Pattern.matches("^1[3456789]\\d{9}$", "28811158945");
        boolean b4 = Pattern.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", "1@1.com");
        boolean b5 = Pattern.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", "11.com");
        assertTrue(b);
        assertTrue(b4);
        assertFalse(b2);
        assertFalse(b3);
        assertFalse(b5);

        boolean b6 = Pattern.matches("^(1[3456789]\\d{9})||([a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+)$", "188111589453");
        boolean b7 = Pattern.matches("^(1[3456789]\\d{9})||([a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+)$", "11.com");
        boolean b8 = Pattern.matches("^(1[3456789]\\d{9})||([a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+)$", "1@1.com");
        assertFalse(b6);
        assertFalse(b7);
        assertTrue(b8);

    }
}
