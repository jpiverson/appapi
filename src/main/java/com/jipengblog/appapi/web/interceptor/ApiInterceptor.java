package com.jipengblog.appapi.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jipengblog.appapi.web.utils.ReqGson;
import com.jipengblog.appapi.web.utils.RespGson;

import site.penn.common.security.TrippleDesUtils;

public class ApiInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = Logger.getLogger(ApiInterceptor.class);

	// 验证正确的标识
	private static final String NO_ERROR_MSG = "NO_ERROR";

	// 保存请求执行时间的线程
	private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("StopWatch-StartTime");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		startTimeThreadLocal.set(System.currentTimeMillis());// 将当前时间放入到线程中（该数据只有当前请求的线程可见）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		logger.info("拦截到请求:::" + request.getRequestURI());
		try {
			String reqCipherText = IOUtils.toString(request.getInputStream());
			logger.info("原始请求数据:::" + reqCipherText);
			if (Strings.isNullOrEmpty(reqCipherText)) {
				throw new Exception("无请求内容");
			}
			long start = System.currentTimeMillis();
			String reqPlainText = TrippleDesUtils.decrypt(reqCipherText);
			logger.info("解密请求数据, 耗时:::" + (System.currentTimeMillis() - start) + "ms");
			start = System.currentTimeMillis();
			ReqGson reqGson = new Gson().fromJson(reqPlainText, ReqGson.class);
			logger.info("封装请求数据, 耗时:::" + (System.currentTimeMillis() - start) + "ms");
			start = System.currentTimeMillis();
			String errorMsg = reqVerificate(reqGson);
			logger.info("验证请求数据, 耗时:::" + (System.currentTimeMillis() - start) + "ms");
			if (NO_ERROR_MSG.equalsIgnoreCase(errorMsg)) {
				logger.info("请求验证通过!准备业务处理.");
				request.setAttribute("params", reqGson.getParams());
			} else {
				logger.info("请求验证失败!结束.");
				RespGson resp = new RespGson(RespGson.CODE_ILLEGAL, errorMsg);
				response.getWriter().print(new GsonBuilder().create().toJson(resp));
				return false;
			}
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {
				logger.debug(e.getMessage());
				e.printStackTrace();
			}
			RespGson resp = new RespGson(RespGson.CODE_WRONG_FORMAT, "参数格式错误");
			response.getWriter().print(new GsonBuilder().create().toJson(resp));
			return false;
		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long beginTime = startTimeThreadLocal.get();// 得到线程绑定的局部变量（开始时间）
		long consumeTime = System.currentTimeMillis() - beginTime;// 3、消耗的时间
		logger.info("请求处理完成:" + request.getRequestURI() + ",耗时:" + consumeTime + "ms");
		super.afterCompletion(request, response, handler, ex);
	}

	/**
	 * 对请求参数进行安全验证
	 * 
	 * @param 请求参数的封装
	 * @return 错误信息
	 */
	private String reqVerificate(ReqGson req) {
		try {
			if (!req.timestampVerificate()) {
				return "请求已过期";
			}
			if (!req.signVerificate()) {
				return "请求不合法";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "参数验证错误";
		}
		return NO_ERROR_MSG;
	}
}