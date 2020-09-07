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
    private Long uid;
    @NotBlank(message = "账户不能为空")
    private String nickname;
    private String name;
    private String avatar;
    private String setQuestionNum;
    private String answerQuestionNum;
    @Pattern(regexp = "\\d{11}",message = "手机号格式无效")
    private String phone;
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
