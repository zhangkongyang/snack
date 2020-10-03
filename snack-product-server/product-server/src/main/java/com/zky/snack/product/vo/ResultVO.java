package com.zky.snack.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zky.snack.product.enums.ResultEnum;

public class ResultVO {
	private Integer code;
	private String msg;

	@JsonProperty("data") // 当以json格式返回数据是，属性名改为data
	private Object obj;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "ResultVO [code=" + code + ", msg=" + msg + ", obj=" + obj + "]";
	}

	public ResultVO(Integer code) {
		super();
		this.code = code;
	}

	public ResultVO(String msg) {
		super();
		this.msg = msg;
	}

	public ResultVO(ResultEnum enums) {
		super();
		this.code=enums.getCode();
		this.msg=enums.getMsg();
	}
	public ResultVO(ResultEnum enums,Object obj) {
		super();
		this.code=enums.getCode();
		this.msg=enums.getMsg();
		this.obj=obj;
	}
	public ResultVO(Object obj) {
		super();
		this.obj = obj;
	}

	public ResultVO(String msg, Object obj) {
		super();
		this.msg = msg;
		this.obj = obj;
	}

	public ResultVO(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public ResultVO(Integer code, String msg, Object obj) {
		super();
		this.code = code;
		this.msg = msg;
		this.obj = obj;
	}

	public ResultVO(Integer code, Object obj) {
		super();
		this.code = code;
		this.obj = obj;
	}

	public ResultVO() {
	}

}
