import com.zigcag.rbac.model.User;
import com.zigcag.rbac.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: zhengchang
 * @Date: 2020/9/6
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@WebAppConfiguration
public class TestUser {

    @Resource
    UserService userService;
    @Test
    public void testAdd() {
        Map<String, Object> params = new HashMap<>();
        List<User> users = userService.listUser(params);
        Assert.assertNotNull(users.get(0));
        System.out.println(13);
    }
}
