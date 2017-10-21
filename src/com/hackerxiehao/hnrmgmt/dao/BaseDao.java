package com.hackerxiehao.hnrmgmt.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

//@Repository
public class BaseDao {
//	
//	@Autowired
//	private SessionFactory sessionFactory;
//	
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		System.out.println(sessionFactory);
//		this.sessionFactory = sessionFactory;
//	}
	
	public Session getSession(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
		return sessionFactory.openSession();
	}
	
}
