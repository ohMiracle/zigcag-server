package com.zigcag.rbac.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Msg {

	private int code;

	private String message;

	private Map<String,Object> data = new HashMap<String, Object>();

	private Msg(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public static Msg message(int code,String message){
		Msg result = new Msg(code,message);
		return result;
	}
	/**
	 * 处理成功时返回的数据
	 * @return
	 */
	public static Msg success(){
		Msg result = new Msg(200,"处理成功");
		return result;
	}

	public static Msg success(String message){
		Msg result = new Msg(200,message);
		return result;
	}

	public static Msg error(){
		Msg result = new Msg(400,"处理失败");
		return result;
	}
	public static Msg error(String message){
		Msg result = new Msg(400,message);
		return result;
	}

	/**
	 * 添加封装的数据，实现链式编程
	 * @param key
	 * @param value
	 * @return
	 */
	public Msg add(String key,Object value){
		this.data.put(key,value);
		return this;
	}

	public Msg add(Map<String,Object> dataMap){
		if(dataMap==null){
			return this;
		}
		dataMap.forEach((k,v)->this.data.put(k,v));
		return this;
	}
}
