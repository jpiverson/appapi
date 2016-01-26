package com.jipengblog.appapi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.google.common.base.MoreObjects;

import site.penn.common.datetime.DatetimeUtils;

@Entity
@Table(name = "customer_account")
public class CustomerAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;// 主键标识

	@Column(nullable = false, length = 50, unique = true)
	private String account;// 用户登记的手机号

	@Column(nullable = false, length = 32)
	private String password;// 登录密码

	@Column(length = 50, unique = true)
	private String email;// 用户登记的邮箱

	@Column(length = 50, unique = true)
	private String mobile;// 用户登记的邮箱

	@Column(length = 50)
	private String description; // 简单描述

	@Column
	@Type(type = "yes_no")
	private Boolean mobileVer;// 手机是否验证

	@Column
	@Type(type = "yes_no")
	private Boolean emailVer;// 邮箱是否验证

	@Column
	@Type(type = "yes_no")
	private Boolean enabled;// 用户状态

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	private Date registerTime;// 注册时间

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "infoId", unique = true)
	private CustomerInfo customerInfo;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", id).add("account", account).add("mobile", mobile)
				.add("email", email).add("description", description).add("mobileVer", mobileVer)
				.add("emailVer", emailVer).add("enabled", enabled)
				.add("registerTime", DatetimeUtils.dateToString(registerTime)).toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

}
