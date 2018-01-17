package com.hl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.dao.UserAccountDao;
import com.hl.entity.UserAccount;

@Service
public class UserAccountService {
	
	@Autowired
	private UserAccountDao userAccountDao;
	
	public List <UserAccount>  getUserPwdById(String accountId){
		return  userAccountDao.getUserPwdById(accountId);
	}
	

}
