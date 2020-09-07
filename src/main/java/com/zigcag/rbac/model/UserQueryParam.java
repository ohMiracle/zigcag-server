package com.zigcag.rbac.model;

import lombok.Data;

/**
 * @Description:
 * @Author: zhengchang
 * @Date: 2020/9/6
 */
@Data
public class UserQueryParam extends BasePageBean {
    private String name;
    private String account;
    private String roleId;
}
