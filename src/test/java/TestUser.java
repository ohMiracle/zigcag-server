import com.zigcag.rbac.model.User;
import com.zigcag.rbac.controller.bean.UserQueryParam;
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

        User user = new User();
        user.setNickname("admin");
        user.setPassword("123456");
        user.setEmail("123@163.com");
        user.setPhone("18811111111");
        String roleId = UUID.randomUUID().toString();
        user.setRoleId(roleId);
        Long aLong = userService.addUser(user);
        System.out.println(aLong);

        UserQueryParam userQueryParam = new UserQueryParam();
        List<User> users = userService.listUser(userQueryParam);
        Assert.assertNotNull(users.get(0));
        // System.out.println(13);
        // Long a = 12131L;
        // String b = a.toString();
        // char[] chars = b.toCharArray();
        // boolean d = true;
        // int i = 1;
        // int in=0;
        // for (char aChar : chars) {
        //     if(i>1){
        //         if (in != aChar && in+1 != aChar ) {
        //             d = false;
        //             break;
        //         }
        //     }
        //     in= aChar;
        //     i++;
        // }
        // System.out.println(d);
    }

    @Test
    public void testConcurrentAdd() {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    User user = new User();
                    user.setNickname("miracle"+Thread.currentThread().getName());
                    String roleId = UUID.randomUUID().toString();
                    user.setRoleId(roleId);
                    Long aLong = userService.addUser(user);
                    System.out.println(aLong);
                }
            }).start();
        }
    }
}
