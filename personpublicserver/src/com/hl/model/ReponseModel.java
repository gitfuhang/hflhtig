package com.hl.model;

/**
 * 返回前台的模型
 * code 0 成功 其他失败
 * message 返回的操作信息
 * data  返回的数据
 * @author Administrator
 *
 */
public class ReponseModel {
	
	private int code;
	private String message;
	private String data;
	
	
    public ReponseModel(int code, String message, String data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}	

}
