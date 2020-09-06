package com.zigcag.rbac.model;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @Description:
 * @Author: zhengchang
 * @Date: 2020/9/6
 */
@Data
public class User{

    private final static Logger logger = LoggerFactory.getLogger(User.class);
    private String id;
    @NotBlank(message = "账户不能为空")
    private String account;
    @NotBlank(message = "姓名不能为空")
    private String name;
    @Pattern(regexp = "\\d{11}",message = "手机号格式无效")
    private String phone;
    @NotBlank(message = "邮箱地址不能为空")
    private String email;
    private String roleName;
    private String salt;
    @Pattern(regexp = "^(\\w){6,26}$",message ="密码应为6-26位英文字母")
    private String password;
    private Integer sex;
    private Date createTime;
    private Date updateTime;
    @NotBlank(message = "角色ID不能为空")
    private String roleId;

}
