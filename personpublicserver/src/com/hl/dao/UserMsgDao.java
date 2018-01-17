package com.hl.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.hl.entity.UserMsg;

@Repository
public class UserMsgDao {
	
		//注入已在spring-common.xml中配制好的sessionFactory
		@Resource(name = "sessionFactory")
		private SessionFactory sessionFactory;
			
		@SuppressWarnings("unchecked")
		public  List <UserMsg> getUserMsgById(String userMsgId){
			
			List <UserMsg> list = new ArrayList<UserMsg>();	
			Query query = sessionFactory.getCurrentSession().createQuery("from UserMsg where Id = '" + userMsgId + "'");
			list =  query.list();
			if (list != null && list.size() > 0) {
				return list; 	
			}else{
				return list;
			}	
	
		}

}
