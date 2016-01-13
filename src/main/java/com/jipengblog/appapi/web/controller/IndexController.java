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
import com.jipengblog.appapi.entity.CustomerAccount;
import com.jipengblog.appapi.entity.CustomerInfo;
import com.jipengblog.appapi.service.CustomerService;
import com.jipengblog.appapi.web.bo.MobsmsBo;
import com.jipengblog.appapi.web.bo.SuperidBo;
import com.jipengblog.appapi.web.utils.RespGson;

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
	CustomerService userService;

	@RequestMapping(value = "/login/mobsms", method = RequestMethod.POST)
	@ResponseBody
	public String loginMobsms(@ModelAttribute("params") String params) {
		MobsmsBo bo = new Gson().fromJson(params, MobsmsBo.class);
		CustomerAccount account = userService.findAccountByMobile(bo.getPhone());
		if (account == null) {
			account = new CustomerAccount();
			account.setAccount(bo.getPhone());
			account.setMobile(bo.getPhone());
			account.setMobileVer(true);
			SignatureUtils utils = new SignatureUtils();
			account.setPassword(utils.encrypt(bo.getPhone()));
			account.setEnabled(true);
			account.setDescription("mob短信注册");
			account.setRegisterTime(new Date());
			userService.save(account);
		}

		CustomerInfo info = userService.findInfoByMobile(bo.getPhone());
		if (info == null) {
			info = new CustomerInfo();
			info.setAvatar(bo.getAvatar());
			info.setNickName(bo.getNickName());
			info.setRegionCode(bo.getCountry());
			info.setMobile(bo.getPhone());
		}
		info.setLastLoginTime(new Date());
		userService.save(info);
		resp = new RespGson(RespGson.CODE_OK, RespGson.DESC_OK, account);
		return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(resp);
	}

	@RequestMapping(value = "/login/superid", method = RequestMethod.POST)
	@ResponseBody
	public String loginSuperid(@ModelAttribute("params") String params) {
		SuperidBo bo = new Gson().fromJson(params, SuperidBo.class);
		// 账号
		CustomerAccount account = userService.findAccountByMobile(bo.getPhone());
		if (account == null) {
			account = new CustomerAccount();
			account.setMobile(bo.getPhone());
			account.setAccount(bo.getPhone());
			SignatureUtils utils = new SignatureUtils();
			account.setPassword(utils.encrypt(bo.getPhone()));
			account.setRegisterTime(new Date());
			account.setEnabled(true);
			account.setDescription("一登注册");
			userService.save(account);
		}

		// 用户信息
		CustomerInfo info = userService.findInfoByMobile(bo.getPhone());
		if (info == null) {
			info = new CustomerInfo();
			info.setMobile(bo.getPhone());
		}
		info.setNickName(bo.getName());
		info.setAvatar(bo.getAvatar());
		info.setRegionCode(bo.getRegioncode());
		info.setGender(bo.getPersona().getGender());
		info.setGeneration(bo.getPersona().getGeneration());
		info.setPersonality(bo.getPersona().getCharacter());
		String location = bo.getPersona().getLocation().getCountry() + "," + bo.getPersona().getLocation().getProvince()
				+ "," + bo.getPersona().getLocation().getCity();
		info.setLocation(location);
		StringBuffer tags = new StringBuffer();
		for (String tag : bo.getPersona().getTags()) {
			tags.append(tag + ",");
		}
		info.setTags(tags.toString());
		info.setLastLoginTime(new Date());
		userService.saveOrUpdate(info);

		resp = new RespGson(RespGson.CODE_OK, RespGson.DESC_OK, account);
		return new GsonBuilder().create().toJson(resp);
	}
}