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

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;

import com.google.common.base.MoreObjects;

@Entity
@Table(name = "user_device_report")
public class UserDeviceReport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long reportId;// 主键标识
	
	@Column(nullable = false)
	private String mobile;// 手机号码

	@Column(nullable = true, length = 20)
	private String longitude;// 纬度坐标

	@Column(nullable = true, length = 20)
	private String latitude;// 经度坐标

	@Column(nullable = true, length = 20)
	private String altitude;// 高度信息，目前没有实现

	@Column(nullable = true, length = 20)
	private String speed;// 速度,仅gps定位结果时有速度信息,单位:公里每小时

	@Column(nullable = true, length = 20)
	private String radius;// 定位精度

	@Column(nullable = true, length = 20)
	private String coorType;// 获取所用坐标系，目前没有实现，以locationClientOption里设定的坐标系为准

	@Column(nullable = true)
	private Integer locType; // 定位类型

	@Column(nullable = true)
	private Integer satelliteNumber;// gps定位结果时，获取gps锁定用的卫星数

	@Column(nullable = true, length = 20)
	private String direction;// 获取手机当前的方向

	@Column(nullable = true, length = 200)
	private String address;// 获取详细地址信息

	@Column(nullable = true, length = 20)
	private String province;// 地址

	@Column(nullable = true, length = 20)
	private String city;// 城市

	@Column(nullable = true, length = 20)
	private String district;// 获取区/县信息

	@Column(nullable = true, length = 50)
	private String street;// 获取街道信息

	@Column(nullable = true, length = 20)
	private String streetNumber;// 获取街道号码

	@Column(nullable = true, length = 20)
	private String floor;// 获取楼层信息,仅室内定位时有效

	@Column(nullable = true, length = 10)
	private String networkLocationType; // 在网络定位结果的情况下，获取网络定位结果是通过基站定位得到的还是通过wifi定位得到的.
										// "wf":wifi定位结果, "cl":cell定位结果,
										// null:没有获取到定位结果采用的类型

	@Column(nullable = true)
	@Type(type = "yes_no")
	private Boolean cellChangeFlag;// 仅在getloctype ==
									// TypeOffLineLocationNetworkFail起作用。
									// 相比上次请求基站是否发生变化

	@Column(nullable = true)
	private Integer operators; // 运营商信息. OPERATORS_TYPE_UNKONW : 未知运营商;
								// OPERATORS_TYPE_MOBILE : 中国移动；
								// OPERATORS_TYPE_UNICOM : 中国联通；
								// OPERATORS_TYPE_TELECOMU : 中国电信

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	private Date reportTime;// 上报时间

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("reportId", reportId).add("mobile", mobile)
				.add("longitude", longitude).add("latitude", latitude).add("altitude", altitude).add("speed", speed)
				.add("radius", radius).add("coorType", coorType).add("locType", locType)
				.add("satelliteNumber", satelliteNumber).add("direction", direction).add("address", address)
				.add("province", province).add("city", city).add("district", district).add("street", street)
				.add("streetNumber", streetNumber).add("floor", floor).add("networkLocationType", networkLocationType)
				.add("cellChangeFlag", cellChangeFlag).add("operators", operators).add("reportTime", reportTime)
				.toString();
	}

	// getter and setter

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	@NotBlank(message="手机号不能为空")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}

	public String getCoorType() {
		return coorType;
	}

	public void setCoorType(String coorType) {
		this.coorType = coorType;
	}

	public Integer getLocType() {
		return locType;
	}

	public void setLocType(Integer locType) {
		this.locType = locType;
	}

	public Integer getSatelliteNumber() {
		return satelliteNumber;
	}

	public void setSatelliteNumber(Integer satelliteNumber) {
		this.satelliteNumber = satelliteNumber;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getNetworkLocationType() {
		return networkLocationType;
	}

	public void setNetworkLocationType(String networkLocationType) {
		this.networkLocationType = networkLocationType;
	}

	public Boolean getCellChangeFlag() {
		return cellChangeFlag;
	}

	public void setCellChangeFlag(String cellChangeFlag) {
		if ("true".equalsIgnoreCase(cellChangeFlag) 
				|| "yes".equalsIgnoreCase(cellChangeFlag)
				|| "y".equalsIgnoreCase(cellChangeFlag)
				|| "1".equals(cellChangeFlag)) {
			this.cellChangeFlag = Boolean.TRUE;
		} else {
			this.cellChangeFlag = Boolean.FALSE;
		}
	}

	public Integer getOperators() {
		return operators;
	}

	public void setOperators(Integer operators) {
		this.operators = operators;
	}

	public Date getReportTime() {
		return reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

}
