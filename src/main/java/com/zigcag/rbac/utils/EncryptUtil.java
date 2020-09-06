package com.zigcag.rbac.utils;

import com.zigcag.rbac.model.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class EncryptUtil {
    //实例化RandomNumberGenerator对象，用于生成一个随机数
    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    //散列算法名称
    private static String algorithName = "MD5";
    //散列迭代次数
    private static int hashInterations = 1024;


    public static void encryptPassword(User user) {
        if(user.getPassword()!=null){
            //对user对象设置盐：salt；这个盐值是randomNumberGenerator生成的随机数，所以盐值并不需要我们指定
            user.setSalt(randomNumberGenerator.nextBytes().toHex());

            //调用SimpleHash指定散列算法参数：1、算法名称；2、用户输入的密码；3、盐值（随机生成的）；4、迭代次数
            String newPassword = new SimpleHash(
                    algorithName,
                    user.getPassword(),
                    ByteSource.Util.bytes(user.getSalt()),
                    hashInterations).toHex();
            user.setPassword(newPassword);
        }
    }
}
