package com.zigcag.rbac.controller.bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @Description: 登录参数
 * @Author: zhengchang
 * @Date: 2020/9/8
 */
public class LoginParam {

    @NotBlank(message = "手机号或邮箱忘输入了呢")
    @Pattern(regexp = "^(1[3456789]\\d{9})||([a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+)$",message = "手机号或邮箱格式无效")
    private String account;
    @NotBlank(message = "请输入密码")
    private String password;
    private Boolean remember;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRemember() {
        return remember;
    }

    public void setRemember(Boolean remember) {
        this.remember = remember;
    }
}
