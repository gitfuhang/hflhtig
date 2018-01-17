package com.hl.dao.company;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hl.entity.UserCompanyMsg;

@Repository
public class UserCompanyMsgDao {
	
	private static Logger logger = Logger.getLogger(UserCompanyMsgDao.class);
	
	//注入已在spring-common.xml中配制好的sessionFactory
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	
	public ArrayList<UserCompanyMsg> getUserCompanyMsgs(String username){
		
		ArrayList <UserCompanyMsg> lists = new ArrayList<UserCompanyMsg>();
		List <UserCompanyMsg> list = new ArrayList<UserCompanyMsg>();
		Query query = sessionFactory.getCurrentSession().createQuery("from UserCompanyMsg where username like '%" + username + "%'");
		list =  query.list();
		if (list != null && list.size() > 0) {
			for(int i=0;i<list.size();i++){
				lists.add(list.get(i));			
			}
			return lists; 	
		}else{
			return lists;
		}	
	}
	
	public boolean delCompanyMsgById(String userId){
		String hql = "delete UserCompanyMsg where Id = '" + userId + "'";
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			return (query.executeUpdate() > 0);
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			logger.info("delCompanyMsgById:"+e.toString());
			return false;
		}			
	}
	
	public UserCompanyMsg getUserById(String userId) {	

		String hql = "from UserCompanyMsg  where Id= '" + userId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return (UserCompanyMsg) query.uniqueResult();
	}

}
