package com.hackerxiehao.hnrmgmt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.hackerxiehao.hnrmgmt.entities.Award;

@Repository
public class AwardDao extends BaseDao {

	/**
	 * 从数据库获取所有记录
	 * 
	 * @return
	 */
	public List<Award> getAll() {
		String hql = "FROM Award";
		return getSession().createQuery(hql).list();
	}

	/**
	 * 从数据库获取指定ID的一条记录
	 * 
	 * @param id
	 * @return
	 */
	public Award get(String id) {
		String hql = "FROM Award a WHERE a.awdID = ?";
		return (Award) getSession().createQuery(hql).setString(0, id).uniqueResult();
	}

	/**
	 * 向数据库添加记录
	 * 
	 * @param award
	 */
	public void save(Award award) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		session.save(award);
		transaction.commit();
		session.close();

	}

	/**
	 * 删除指定ID的记录
	 * 
	 * @param awdID
	 */
	public void delete(String awdID) {
		String hql = "DELETE FROM Award a WHERE a.awdID = ?";
		getSession().createQuery(hql).setString(0, awdID).executeUpdate();
	}

	/**
	 * 根据ID修改记录
	 * 
	 * @param award
	 *            传入的award的json对象
	 */
	public void modify(Award award) {
		String hql = "UPDATE Award a SET a.name = ?, a.gradeName = ?, a.grade = ? WHERE a.awdID = ?";
		getSession().createQuery(hql).setString(0, award.getName()).setString(1, award.getGradeName())
				.setString(2, award.getGrade()).setString(3, award.getAwdID()).executeUpdate();
	}

}
