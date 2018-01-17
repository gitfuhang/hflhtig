package com.hl.service.company;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.dao.company.UserCompanyMsgDao;
import com.hl.entity.UserCompanyMsg;

@Service
public class UserCompanyMsgService {
	@Autowired
	private UserCompanyMsgDao userCompanyMsgDao;
	
	/**
	 * 根据员工名查询展示员工列表
	 * @param username
	 * @return
	 */
	public ArrayList<UserCompanyMsg> getUserCompanyMsgs(String username){
		
		return userCompanyMsgDao.getUserCompanyMsgs(username);
	}
	
	/**
	 * 根据员工Id 查询一个员工信息
	 * @param userId
	 * @return
	 */
	public UserCompanyMsg getUserById(String userId){
		
		return userCompanyMsgDao.getUserById(userId);
	}
	
	/**
	 * 根据员工Id 删除用户信息
	 * @param userId
	 * @return
	 */
	public boolean delCompanyMsgById(String userId){
		
		return userCompanyMsgDao.delCompanyMsgById(userId);
				
	}
	

}
