import com.zigcag.rbac.model.User;
import com.zigcag.rbac.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.*;

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
        Long a = 12131L;
        String b = a.toString();
        char[] chars = b.toCharArray();
        boolean d = true;
        int i = 1;
        int in=0;
        for (char aChar : chars) {
            if(i>1){
                if (in != aChar && in+1 != aChar ) {
                    d = false;
                    break;
                }
            }
            in= aChar;
            i++;
        }
        System.out.println(d);
    }
}
