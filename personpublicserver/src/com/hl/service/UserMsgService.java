package com.hl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.dao.UserMsgDao;
import com.hl.entity.UserMsg;

@Service
public class UserMsgService {
	
	@Autowired
	private UserMsgDao userMsgDao;
	
	public List <UserMsg>  getUserMsgById(String userMsgId){
		
		return userMsgDao.getUserMsgById(userMsgId);
		
	}
	
	
}
