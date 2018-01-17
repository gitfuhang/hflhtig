package com.hl.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hl.entity.UserAccount;
import com.hl.entity.UserMsg;
import com.hl.service.UserAccountService;
import com.hl.service.UserMsgService;

@Controller
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserAccountService userAccountService;
	
	@Autowired
	private UserMsgService userMsgService;
	/*
	 * 用户登录
	 */
	@RequestMapping("user/login.do")
	public String  userLogin(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		//ReponseModel resModel = new ReponseModel(1,"","");
		UserAccount userAccount = new UserAccount();
		List <UserAccount> userAccounts = new ArrayList<UserAccount>();
		JSONObject resultObj = new JSONObject();
		Integer code = 1;
		String mssage ="";
		
		String accountId =  request.getParameter("accountId");
		String accountPwd = request.getParameter("accountPwd");		
		String automaticLogin = request.getParameter("automaticLogin");

		userAccounts = userAccountService.getUserPwdById(accountId);
		if(userAccounts != null && userAccounts.size() > 0){
			userAccount = userAccounts.get(0);
			String pwd = userAccount.getAccountPwd();
			String usermsgid = userAccount.getUserMsgId();
			if(accountPwd.equals(pwd)){
				
				List <UserMsg> userMsglist = new ArrayList<UserMsg>();
				UserMsg userMsg = new UserMsg();
				
				userMsglist = userMsgService.getUserMsgById(usermsgid);		
				userMsg = userMsglist.get(0);
				
				// 创建或者获取session对象
				HttpSession sessionAuto = request.getSession();
				// 修改session
				sessionAuto.setMaxInactiveInterval(1 * 24 * 60 * 60);// 秒后session对象将要被销毁
				
				//是否点击自动登录
				if(!StringUtils.isEmpty(automaticLogin) && automaticLogin.equals("yes")){
					//保存会话数据（作为域对象）用于是否自动登录标识
					sessionAuto.setAttribute("userMsgInfoAuto", userMsg);							
					}
				//用于是否已登录标识
				sessionAuto.setAttribute("userMsgInfo", userMsg);
				
				code = 0;
				mssage = "登录成功";
/*				resModel.setCode(0);
				resModel.setData("");*/
			}else{
				//resModel.setMessage("账户密码错误");
				mssage = "账户密码错误";
			}
		}else{
			mssage = "该账户不存在";
			//resModel.setMessage("该账户不存在");
		}
		
		resultObj.put("code",code);
		resultObj.put("Result","" );
		resultObj.put("msg", mssage);
		
		logger.info("user/login.do:"+resultObj.toString());
		response.getWriter().write(resultObj.toString());
		//response.getWriter().write(resModel.toString());
					
		return null;
	}
	
	/**
	 * 用户已登录 获取用户基础信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("user/getUserMsg.do")
	public String getUserMsg(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		JSONObject resultObj = new JSONObject();
		UserMsg userMsg = new UserMsg();
		Integer code = 1;
		String mssage ="";
		
		Integer loginCode =  getUserMsgSessionCode(request);
		switch (loginCode) {
		case 1:
			mssage ="用户未登录";
			break;
		case 2:
			code = 3;
			mssage ="用户已登录未自动登录";
			userMsg = getUserMsgInfoBySession(request);
			break;
		case 3:
			code = 0;
			mssage ="用户已登录且自动登录";
			userMsg = getUserMsgInfoBySession(request);
			break;
		default:
			code = -1;
			mssage ="未知返回码";
			break;
		}
			
		resultObj.put("code",code);
		resultObj.put("Result",userMsg);
		resultObj.put("msg", mssage);
		
		logger.info("getUserMsg():"+resultObj.toString());
		response.getWriter().write(resultObj.toString());
		
		return null;
		
	}
	
	/**
	 * 用于判断用户是否登录或者登录时是否点击自动登录
	 * 
	 * @return loginCode  1 未登录 2 已登录但未点击自动登录 3已登录且自动登录 
	 * @throws Exception 
	 */
	private Integer getUserMsgSessionCode(HttpServletRequest request) throws Exception{
		
		Integer loginCode = 1;
				
		HttpSession sessionAuto = request.getSession(false);
		if(sessionAuto == null ){
			
		}else{
			Object objectAuto = sessionAuto.getAttribute("userMsgInfoAuto");
			Object object = sessionAuto.getAttribute("userMsgInfo");
			if(objectAuto== null && object != null){
				loginCode = 2;
			}else{
				loginCode = 3;
			}
			UserMsg userMsg = new UserMsg();
			userMsg = (UserMsg)object;	
		}
		
		return loginCode;
		
	}
	
	/**
	 * 用户点击查看个人信息
	 * 
	 * @return userMsg
	 * @throws Exception 
	 */
	private UserMsg getUserMsgInfoBySession(HttpServletRequest request) throws Exception{
			
		HttpSession sessionAuto = request.getSession(false);
		Object object = sessionAuto.getAttribute("userMsgInfo");	
		UserMsg userMsg = new UserMsg();
		userMsg = (UserMsg)object;	
			
		return userMsg;
		
	}
	

}
