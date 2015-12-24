package com.jipengblog.appapi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.google.common.base.MoreObjects;
import com.jipengblog.appapi.entity.constant.Sex;

import site.penn.common.datetime.DatetimeUtils;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;// 主键标识

	@Column(nullable = false, length = 20, unique = true)
	private String mobile;// 用户登记的手机号

	@Column(nullable = false, length = 32)
	private String loginPass;// 登录密码

	@Column(nullable = true, length = 50, unique = true)
	private String email;// 用户登记的邮箱

	@Column(nullable = true, length = 20, unique = true)
	private String nickName;// 用户昵称

	@Column
	@Enumerated(EnumType.STRING)
	private Sex sex;// 性别

	@Column(length = 200)
	private String avatar; // 头像

	@Column
	@Type(type = "yes_no")
	private Boolean mobileVer;// 手机是否验证

	@Column
	@Type(type = "yes_no")
	private Boolean emailVer;// 邮箱是否验证

	@Column(length = 100)
	private String description; // 头像

	@Column
	@Type(type = "yes_no")
	private Boolean enabled;// 用户状态

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	private Date registerTime;// 注册时间

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date lastLoginTime;// 最近一次登录时间

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("userId", userId).add("mobile", mobile).add("email", email)
				.add("nickName", nickName).add("sex", sex.toString()).add("avatar", avatar).add("mobileVer", mobileVer)
				.add("emailVer", emailVer).add("description", description).add("enabled", enabled)
				.add("registerTime", DatetimeUtils.dateToString(registerTime))
				.add("lastLoginTime", DatetimeUtils.dateToString(lastLoginTime)).toString();
	}

	// getter and setter

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLoginPass() {
		return loginPass;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Boolean getMobileVer() {
		return mobileVer;
	}

	public void setMobileVer(Boolean mobileVer) {
		this.mobileVer = mobileVer;
	}

	public Boolean getEmailVer() {
		return emailVer;
	}

	public void setEmailVer(Boolean emailVer) {
		this.emailVer = emailVer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
}
