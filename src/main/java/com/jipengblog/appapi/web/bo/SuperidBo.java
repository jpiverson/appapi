package com.jipengblog.appapi.web.bo;

import java.util.List;

public class SuperidBo {
	private String phone;
	private String name;
	private String avatar;
	private String regioncode;
	private Persona persona;
	private String group_uid;
	private String openId;

	public String getPhone() {
		return phone;
	}

	public String getName() {
		return name;
	}

	public String getAvatar() {
		return avatar;
	}

	public String getRegioncode() {
		return regioncode;
	}

	public Persona getPersona() {
		return persona;
	}

	public String getGroupUid() {
		return group_uid;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public class Persona {
		private String gender;
		private List<String> tags;
		private Location location;
		private String generation;
		private String character;

		public String getGender() {
			return gender;
		}

		public List<String> getTags() {
			return tags;
		}

		public Location getLocation() {
			return location;
		}

		public String getGeneration() {
			return generation;
		}

		public String getCharacter() {
			return character;
		}
	}

	public class Location {
		private String country;
		private String province;
		private String city;

		public String getCountry() {
			return country;
		}

		public String getProvince() {
			return province;
		}

		public String getCity() {
			return city;
		}
	}
}
