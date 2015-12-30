package com.jipengblog.appapi.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jipengblog.appapi.entity.Superid;
import com.jipengblog.appapi.entity.User;
import com.jipengblog.appapi.service.UserService;
import com.jipengblog.appapi.web.bo.SuperidBo;
import com.jipengblog.appapi.web.utils.RespGson;

import site.penn.common.base.Constants;
import site.penn.common.security.SignatureUtils;

/**
 * 登录, 注册
 * 
 * @author penn
 *
 */
@Controller
public class IndexController extends ParentController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login/mobsms", method = RequestMethod.POST)
	@ResponseBody
	public String loginMobsms(@ModelAttribute("params") String params) {
		User user = new Gson().fromJson(params, User.class);
		User existUser = userService.findByMobile(user.getMobile());
		if (existUser == null) {
			existUser = new User();
		}

		existUser.setMobile(user.getMobile());
		existUser.setMobileVer(true);
		SignatureUtils utils = new SignatureUtils();
		existUser.setLoginPass(utils.encrypt(user.getMobile()));
		existUser.setAvatar(Constants.DEFAULT_AVATAR);
		existUser.setEnabled(true);
		existUser.setRegisterTime(new Date());
		existUser.setLastLoginTime(new Date());
		userService.saveOrUpdate(existUser);
		resp = new RespGson(RespGson.CODE_OK, RespGson.DESC_OK, existUser);
		return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(resp);
	}

	@RequestMapping(value = "/login/superid", method = RequestMethod.POST)
	@ResponseBody
	public String loginSuperid(@ModelAttribute("params") String params) {
		SuperidBo bo = new Gson().fromJson(params, SuperidBo.class);
		Superid superid = userService.findByPhone(bo.getPhone());
		if (superid == null) {
			superid = new Superid();
		}
		superid.setPhone(bo.getPhone());
		superid.setName(bo.getName());
		superid.setAvatar(bo.getAvatar());
		superid.setRegioncode(bo.getRegioncode());
		superid.setGroupUid(bo.getGroupUid());
		superid.setGender(bo.getPersona().getGender());
		superid.setGeneration(bo.getPersona().getGeneration());
		superid.setPersonality(bo.getPersona().getCharacter());
		String location = bo.getPersona().getLocation().getCountry() + "," + bo.getPersona().getLocation().getProvince()
				+ "," + bo.getPersona().getLocation().getCity();
		superid.setLocation(location);
		StringBuffer tags = new StringBuffer();
		for (String tag : bo.getPersona().getTags()) {
			tags.append(tag + ",");
		}
		superid.setTags(tags.toString());
		superid.setLastLoginTime(new Date());
		userService.saveOrUpdate(superid);
		resp = new RespGson(RespGson.CODE_OK, RespGson.DESC_OK, null);
		return new GsonBuilder().create().toJson(resp);
	}
}