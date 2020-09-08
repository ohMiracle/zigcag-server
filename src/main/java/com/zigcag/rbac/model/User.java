package com.zigcag.rbac.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: zhengchang
 * @Date: 2020/9/6
 */
public class User{
    //TODO 用户是存在shiro会话中的，需要确认是否要实现序列化接口
    /**
     * 用户的唯一ID
     */
    private Long uid;
    /**
     * 昵称，可重复
     */
    @NotBlank(message = "昵称不能为空")
    private String nickname;
    /**
     * 姓名
     */
    private String name;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 设置题目数量
     */
    private String setQuestionNum;
    /**
     * 答题数量
     */
    private String answerQuestionNum;
    /**
     * 手机号
     */
    @Pattern(regexp = "^1[3456789]\\d{9}$",message = "手机号格式无效")
    private String phone;
    /**
     * 邮箱地址
     */
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",message = "邮箱格式无效")
    private String email;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 盐
     */
    private String salt;
    /**
     * 密码
     */
    @Pattern(regexp = "^(\\w){6,26}$",message ="密码应为6-26位英文字母")
    private String password;
    /**
     * 性别 1 男 2 女
     */
    private Integer sex;
    private Boolean remember;
    private Date createTime;
    private Date updateTime;
    @NotBlank(message = "角色ID不能为空")
    private String roleId;
    private List<Menu> menuList;

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Boolean getRemember() {
        return remember;
    }

    public void setRemember(Boolean remember) {
        this.remember = remember;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSetQuestionNum() {
        return setQuestionNum;
    }

    public void setSetQuestionNum(String setQuestionNum) {
        this.setQuestionNum = setQuestionNum;
    }

    public String getAnswerQuestionNum() {
        return answerQuestionNum;
    }

    public void setAnswerQuestionNum(String answerQuestionNum) {
        this.answerQuestionNum = answerQuestionNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
