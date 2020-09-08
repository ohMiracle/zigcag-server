package com.zigcag.rbac.exception;


import com.zigcag.rbac.model.Msg;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * 全局异常处理,所有的异常都放在这里进行处理,无需在每个地方try catch
 *
 */
@RestControllerAdvice
public class ExceptionAdvice {
	private Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);
	/**
	 * 信息无法读取
	 * @param e
	 * @return
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Msg handleHttpMessageNotReadableException(Exception e){
		e.printStackTrace();
		return Msg.message(400,"无法读取");
	}

	/**
	 * 处理参数异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Msg handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        ObjectError error = e.getBindingResult().getAllErrors().get(0);
		logger.info("数据验证异常：{}", error.getDefaultMessage());
		return Msg.message(400,error.getDefaultMessage());
	}

	/**
	 * 处理自定义异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(RbacException.class)
	@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
	public Msg handleIException(RbacException e){
		return Msg.message(417,e.getMessage());
	}

	// /**
	//  * 登陆错误
	//  * @param e
	//  * @return
	//  */
	// @ExceptionHandler(AuthenticationException.class)
	// @ResponseStatus(HttpStatus.UNAUTHORIZED)
	// public Msg handleAuthenticationException(AuthenticationException e){
	// 	LOGGER.error(e);
	// 	return Msg.message(401,"登陆错误");
	// }
    //
	// @ExceptionHandler(UnknownAccountException.class)
	// @ResponseStatus(HttpStatus.UNAUTHORIZED)
	// public Msg handleUnknownAccountException(UnknownAccountException e){
	// 	LOGGER.error(e);
	// 	return Msg.message(401,"请登录");
	// }


	/**
	 * 没有权限——shiro
	 * @param e
	 * @return
	 */
	@ExceptionHandler(UnauthorizedException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public Msg handleUnauthorizedException(UnauthorizedException e){
		return Msg.message(403,"没有权限");
	}
}
