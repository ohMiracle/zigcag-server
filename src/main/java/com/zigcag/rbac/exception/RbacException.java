package com.zigcag.rbac.exception;

import lombok.Data;

/**
 * @Description:
 * @Author: zhengchang
 * @Date: 2020/9/6
 */
@Data
public class RbacException extends RuntimeException{
    private static final long serialVersionUID = 7144771828212718116L;
    private String message;

    public RbacException(String message){
        this.message = message;
    }
}
