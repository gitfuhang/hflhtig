package com.hl.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="usermsg")
public class UserMsg implements Serializable {

	/**
	 * 用户基本信息
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(length = 36)
	private String Id; //对应useraccount 表 usercode
	
	@Column(name="username")
	private String userName;//姓名
	@Column(name="gender")
	private String gender;//性别
	@Column(name="age")
	private String age;//年龄
	@Column(name="bloodtype")
	private String bloodType;//血型
	@Column(name="workingyears")
	private String workingYears;//工作年限
	@Column(name="workingposition")
	private String workingPosition;//职位
	@Column(name="department")
	private String departMent;//部门
	@Column(name="birthday")
	private String birthDay;//出生日期
	@Column(name="constellation")
	private String constellation; //星座
	@Column(name="motto",length=100)
	private String motto; //座右铭
	@Column(name="workingcourse",length=800)
	private String workingCourse; //工作历程
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getWorkingYears() {
		return workingYears;
	}
	public void setWorkingYears(String workingYears) {
		this.workingYears = workingYears;
	}
	public String getWorkingPosition() {
		return workingPosition;
	}
	public void setWorkingPosition(String workingPosition) {
		this.workingPosition = workingPosition;
	}
	public String getDepartMent() {
		return departMent;
	}
	public void setDepartMent(String departMent) {
		this.departMent = departMent;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getConstellation() {
		return constellation;
	}
	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}
	public String getWorkingCourse() {
		return workingCourse;
	}
	public void setWorkingCourse(String workingCourse) {
		this.workingCourse = workingCourse;
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
