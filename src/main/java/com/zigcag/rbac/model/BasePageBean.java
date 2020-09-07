package com.zigcag.rbac.model;

import lombok.Data;

import java.util.UUID;

/**
 * @Description:
 * @Author: zhengchang
 * @Date: 2020/9/6
 */
@Data
public class BasePageBean {
    private int pageSize;
    private int current;
}
