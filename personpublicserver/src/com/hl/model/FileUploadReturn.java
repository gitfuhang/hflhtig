package com.hl.model;

/**
 * 文件上传返回实体
 * @author Administrator
 * uploadCode 返回码标识 0 成功 其他为失败
 * uploadMsg 返回信息
 * uploadFilepath 上传文件路径
 * uploadFilename 上传文件名
 *
 */
public class FileUploadReturn {
	private Integer uploadCode;
	private String uploadMsg;
	private String uploadFilepath;
	private String uploadFilename;
	
	public Integer getUploadCode() {
		return uploadCode;
	}
	public void setUploadCode(Integer uploadCode) {
		this.uploadCode = uploadCode;
	}
	public String getUploadMsg() {
		return uploadMsg;
	}
	public void setUploadMsg(String uploadMsg) {
		this.uploadMsg = uploadMsg;
	}
	public String getUploadFilepath() {
		return uploadFilepath;
	}
	public void setUploadFilepath(String uploadFilepath) {
		this.uploadFilepath = uploadFilepath;
	}
	public String getUploadFilename() {
		return uploadFilename;
	}
	public void setUploadFilename(String uploadFilename) {
		this.uploadFilename = uploadFilename;
	}
	
	
	

}
