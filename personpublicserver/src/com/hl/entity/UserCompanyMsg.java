package com.hl.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="usercompanymsg")
public class UserCompanyMsg implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(length = 36)
	private String Id; //
	
	@Column(name="username")
	private String userName;//姓名
	@Column(name="gender")
	private String gender;//性别
	@Column(name="birthday")
	private String birthDay;//出生日期
	@Column(name="department")
	private String departMent;//部门
	@Column(name="workingposition")
	private String workingPosition;//职位
	@Column(name="workingyears")
	private String workingYears;//工作年限
	@Column(name="socialsecurity")
	private String socialSecurity;//社保
	@Column(name="salarytreatment")
	private String salaryTreatment;//薪酬待遇
	@Column(name="remarks",length=200)
	private String remarks; //备注
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getDepartMent() {
		return departMent;
	}
	public void setDepartMent(String departMent) {
		this.departMent = departMent;
	}
	public String getWorkingPosition() {
		return workingPosition;
	}
	public void setWorkingPosition(String workingPosition) {
		this.workingPosition = workingPosition;
	}
	public String getWorkingYears() {
		return workingYears;
	}
	public void setWorkingYears(String workingYears) {
		this.workingYears = workingYears;
	}
	public String getSocialSecurity() {
		return socialSecurity;
	}
	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}
	public String getSalaryTreatment() {
		return salaryTreatment;
	}
	public void setSalaryTreatment(String salaryTreatment) {
		this.salaryTreatment = salaryTreatment;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	


}
