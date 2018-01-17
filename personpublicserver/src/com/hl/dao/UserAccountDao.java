package com.hl.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hl.entity.UserAccount;

@Repository
public class UserAccountDao {
	
	//注入已在spring-common.xml中配制好的sessionFactory
		@Resource(name = "sessionFactory")
		private SessionFactory sessionFactory;
	
		@SuppressWarnings("unchecked")
		public List <UserAccount>  getUserPwdById(String accountId){
			
			List <UserAccount> list = new ArrayList<UserAccount>();		
			Query query = sessionFactory.getCurrentSession().createQuery("from UserAccount where accountId = '" + accountId + "'");
			list = query.list();
			if (list != null && list.size() > 0) {
				return list; 	
			}else{
				return list;
			}	
		}
	

}
