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

import site.penn.common.datetime.DatetimeUtils;

@Entity
@Table(name = "customer_info")
public class CustomerInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;// 主键标识

	@Column(length = 50)
	private String nickName;// 昵称

	@Column(length = 100)
	private String avatar;// 头像

	@Column(length = 10)
	private String regionCode;// 地区代码

	@Column(length = 100)
	private String tags;// 标签

	@Column(length = 10)
	private String gender;// 性别

	@Column(length = 50)
	private String location;// 位置

	@Column(length = 10)
	private String generation;// 年代

	@Column(length = 10)
	private String personality;// 性格

	@Column(length = 64)
	private String openId; // 第三方ID

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date lastLoginTime;// 最近一次登录时间

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", id).add("nickName", nickName).add("avatar", avatar)
				.add("regionCode", regionCode).add("tags", tags).add("gender", gender).add("location", location)
				.add("generation", generation).add("personality", personality).add("openId", openId)
				.add("lastLoginTime", DatetimeUtils.dateToString(lastLoginTime)).toString();
	}

	// getter & setter

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
}
