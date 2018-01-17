package com.hl.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "useraccount")
public class UserAccount implements Serializable {

	/**
	 * 用户账户信息实体
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(length = 32)
	private String Id;
	
	@Column(name="usermsgid")
	private String userMsgId;
	
	@Column(name="accountid")
	private String accountId;
	
	@Column(name="accountpwd")
	private String accountPwd;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getUserMsgId() {
		return userMsgId;
	}

	public void setUserMsgId(String userMsgId) {
		this.userMsgId = userMsgId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountPwd() {
		return accountPwd;
	}

	public void setAccountPwd(String accountPwd) {
		this.accountPwd = accountPwd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
