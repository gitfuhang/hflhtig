package com.hl.controller.company;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hl.entity.UserCompanyMsg;
import com.hl.service.company.UserCompanyMsgService;
import com.hl.util.CalculationAge;

@Controller
public class UserCompanyMsgController {
	
	private static final Logger logger = Logger.getLogger(UserCompanyMsgController.class);
	
	@Autowired
	private UserCompanyMsgService userCompanyMsgService;
	
	
	@RequestMapping("company/getuserCompanyMsg.do")
	public void getCompanyUserMsg(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		JSONObject resultObj = new JSONObject();
		JSONArray resultArray = new JSONArray();
		ArrayList<UserCompanyMsg> userCompanyMsgs = new ArrayList<UserCompanyMsg>();
		Integer code = 1;
		String mssage ="";
		
		String userName = request.getParameter("userName");
		if(StringUtils.isEmpty(userName)){
			userName="";
		}
		
		userCompanyMsgs = userCompanyMsgService.getUserCompanyMsgs(userName);
		if(userCompanyMsgs !=null && userCompanyMsgs.size()>0){
			for(int i=0;i<userCompanyMsgs.size();i++){
				UserCompanyMsg userCompanyMsg = new UserCompanyMsg();
				
				JSONObject userCompanyMsgObj = new JSONObject();
				userCompanyMsg =userCompanyMsgs.get(i);
				userCompanyMsgObj.put("userId", userCompanyMsg.getId());
				userCompanyMsgObj.put("userName", userCompanyMsg.getUserName());
				userCompanyMsgObj.put("gender", userCompanyMsg.getGender());
				
				Integer age = CalculationAge.getAgeByBirth(userCompanyMsg.getBirthDay());	
				userCompanyMsgObj.put("age", age);
				
				userCompanyMsgObj.put("departMent", userCompanyMsg.getDepartMent());
				userCompanyMsgObj.put("socialSecurity", userCompanyMsg.getSocialSecurity());
				userCompanyMsgObj.put("salaryTreatment", userCompanyMsg.getSalaryTreatment());
				userCompanyMsgObj.put("workingYears", userCompanyMsg.getWorkingYears());		
				userCompanyMsgObj.put("remarks", userCompanyMsg.getRemarks());
				
				resultArray.add(userCompanyMsgObj);	
				code = 0;
				mssage = "查询成功";
			}
			
		}
				
		resultObj.put("code",code);
		resultObj.put("Result",resultArray);
		resultObj.put("msg", mssage);
		
		logger.info("company/getuserCompanyMsg.do:"+resultObj.toString());
		response.getWriter().write(resultObj.toString());
		
	}
	
	@RequestMapping("company/delCompanyUserMsg.do")
	public void delCompanyUserMsg(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		JSONObject resultObj = new JSONObject();
		JSONArray resultArray = new JSONArray();
		ArrayList<UserCompanyMsg> userCompanyMsgs = new ArrayList<UserCompanyMsg>();
		UserCompanyMsg userCompanyMsg = new UserCompanyMsg();
		Integer code = 1;
		String mssage ="";
		
		String userId = request.getParameter("userId");
		if(StringUtils.isEmpty(userId)){
			mssage="员工Id为空,请求拒绝";
		}else{
			userCompanyMsg = userCompanyMsgService.getUserById(userId);
			if(userCompanyMsg !=null){
				
				Boolean delBoolean = userCompanyMsgService.delCompanyMsgById(userId);
				if(delBoolean){
					code = 0;
					mssage = "删除成功";
				}else{
					mssage = "删除失败,请校验";
				}
				
			}else{
				mssage="无此员工信息";
				logger.info("该员工不存在");			
			}
			
		}
		
		resultObj.put("code",code);
		resultObj.put("Result",resultArray);
		resultObj.put("msg", mssage);
		
		logger.info("company/getuserCompanyMsg.do:"+resultObj.toString());
		response.getWriter().write(resultObj.toString());
		
	}
	
	@RequestMapping("company/getCompanyUserMsgById.do")
	public void getCompanyUserMsgById(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		JSONObject resultObj = new JSONObject();
		JSONArray resultArray = new JSONArray();
		ArrayList<UserCompanyMsg> userCompanyMsgs = new ArrayList<UserCompanyMsg>();
		UserCompanyMsg userCompanyMsg = new UserCompanyMsg();
		Integer code = 1;
		String mssage ="";
		
		String userId = request.getParameter("userId");
		if(StringUtils.isEmpty(userId)){
			mssage="员工Id为空,请求拒绝";
		}else{
			userCompanyMsg = userCompanyMsgService.getUserById(userId);
			if(userCompanyMsg !=null){
				
				JSONObject userCompanyMsgObj = new JSONObject();
				userCompanyMsgObj.put("userId", userCompanyMsg.getId());
				userCompanyMsgObj.put("userName", userCompanyMsg.getUserName());
				userCompanyMsgObj.put("gender", userCompanyMsg.getGender());
				
				Integer age = CalculationAge.getAgeByBirth(userCompanyMsg.getBirthDay());	
				userCompanyMsgObj.put("age", age);
				
				userCompanyMsgObj.put("departMent", userCompanyMsg.getDepartMent());
				userCompanyMsgObj.put("socialSecurity", userCompanyMsg.getSocialSecurity());
				userCompanyMsgObj.put("salaryTreatment", userCompanyMsg.getSalaryTreatment());
				userCompanyMsgObj.put("workingYears", userCompanyMsg.getWorkingYears());		
				userCompanyMsgObj.put("remarks", userCompanyMsg.getRemarks());
				
				resultArray.add(userCompanyMsgObj);	
						
				code = 0;
				mssage = "查询成功";
			}else{
				mssage="无此员工信息";
				logger.info("该员工不存在");			
			}
			
		}
		
		resultObj.put("code",code);
		resultObj.put("Result",resultArray);
		resultObj.put("msg", mssage);
		
		logger.info("company/getuserCompanyMsg.do:"+resultObj.toString());
		response.getWriter().write(resultObj.toString());
		
	}
}
