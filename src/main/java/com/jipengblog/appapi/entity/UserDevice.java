package com.jipengblog.appapi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.common.base.MoreObjects;
import com.jipengblog.appapi.web.utils.time.DateUtils;

@Entity
@Table(name = "user_device")
public class UserDevice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long deviceId;// 主键标识

	@Column(nullable = false, length = 20, unique = true)
	private String mobile;// 用户登记的手机号

	@Column(nullable = true, length = 10, unique = false)
	private String brand;// 手机品牌

	@Column(nullable = true, length = 10, unique = false)
	private String os;// 手机设备的操作系统

	@Column(nullable = true, length = 10, unique = false)
	private String osVersion;// 手机设备的操作系统的版本

	@Column(nullable = true, length = 10, unique = false)
	private String appVersion;// 手机软件的版本

	@Column(nullable = true, length = 32, unique = true)
	private String deviceToken;// 手机设备的Token唯一标识一个手机设备

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	private Date createTime;// 创建时间

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("deviceId", deviceId).add("mobile", mobile).add("brand", brand)
				.add("os", os).add("osVersion", osVersion).add("deviceToken", deviceToken)
				.add("createTime", DateUtils.dateToString(createTime)).toString();
	}

	// getter and setter

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
