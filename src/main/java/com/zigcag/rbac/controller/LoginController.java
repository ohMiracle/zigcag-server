package com.zigcag.rbac.controller;

import com.zigcag.rbac.model.Msg;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: zhengchang
 * @Date: 2020/9/6
 */
@RestController
public class LoginController {
    public Msg login() {

        return Msg.success();
    }


}
