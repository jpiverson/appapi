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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;

import com.google.common.base.MoreObjects;

@Entity
@Table(name = "app_version")
public class AppVersion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;// 主键标识

	@Column(nullable = false, length = 20, unique = true)
	private String versionName;// 版本名称

	@Column(nullable = false, length = 50, unique = true)
	private String description;// 描述

	@Column(nullable = false)
	@Type(type = "yes_no")
	private Boolean forcedUpdate;// 是否强制更新

	@Column(nullable = false, length = 20, unique = true)
	private String versionNumber;// 版本号,版本号格式为majorVersion.minorVersion.revisionVersion

	@Column(nullable = false, columnDefinition = "int default 0")
	private Integer majorVersion; // 主版本号

	@Column(nullable = false, columnDefinition = "int default 0")
	private Integer minorVersion; // 子版本号

	@Column(nullable = false, columnDefinition = "int default 0")
	private Integer revisionVersion; // 修正版本号

	@Column(nullable = true, length = 50)
	private String downloadUrl;// 下载地址

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	private Date createTime;// 创建时间

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", id).add("versionName", versionName)
				.add("description", description).add("forcedUpdate", forcedUpdate).add("versionNumber", versionNumber)
				.add("majorVersion", majorVersion).add("minorVersion", minorVersion)
				.add("revisionVersion", revisionVersion).add("downloadUrl", downloadUrl).add("createTime", createTime)
				.toString();
	}

	// getter & setter

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotBlank(message = "名称不能为空")
	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	@NotBlank(message = "描述不能为空")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getForcedUpdate() {
		return forcedUpdate;
	}

	public void setForcedUpdate(Boolean forcedUpdate) {
		this.forcedUpdate = forcedUpdate;
	}

	public void setForcedUpdate(String forcedUpdate) {
		if ("true".equalsIgnoreCase(forcedUpdate) || "yes".equalsIgnoreCase(forcedUpdate)
				|| "y".equalsIgnoreCase(forcedUpdate) || "1".equals(forcedUpdate)) {
			this.forcedUpdate = Boolean.TRUE;
		} else {
			this.forcedUpdate = Boolean.FALSE;
		}
	}

	public String getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	@NotNull(message = "主版本号不能为空")
	public Integer getMajorVersion() {
		return majorVersion;
	}

	public void setMajorVersion(Integer majorVersion) {
		this.majorVersion = majorVersion;
	}

	@NotNull(message = "子版本号不能为空")
	public Integer getMinorVersion() {
		return minorVersion;
	}

	public void setMinorVersion(Integer minorVersion) {
		this.minorVersion = minorVersion;
	}

	@NotNull(message = "修正版本号不能为空")
	public Integer getRevisionVersion() {
		return revisionVersion;
	}

	public void setRevisionVersion(Integer revisionVersion) {
		this.revisionVersion = revisionVersion;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
