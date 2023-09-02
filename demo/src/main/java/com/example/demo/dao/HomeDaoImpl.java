package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public class HomeDaoImpl implements HomeDao{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public void saveStudentData(Student student) {
		// TODO Auto-generated method stub
		System.out.println("In Dao Layer : " + student);
		Session session = sf.openSession();
		session.save(student);
		session.beginTransaction().commit();
	}

	@Override
	public List<Student> getLoginData(String uname, String pass) {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<Student>();
		Session session = sf.openSession();
		if("admin".equals(uname) && "admin".equals(pass)) {
			list = session.createQuery("from Student").getResultList();
		}else {
			try {
			Query<Student> query = session.createQuery("from Student where uname=:un and pass=:ps");
			query.setParameter("un", uname);
			query.setParameter("ps", pass);
			Student student = query.getSingleResult();
			list.add(student);
			}catch (NoResultException e) {
				// TODO: handle exception
				System.out.println("Invalid Username and password.");
			}
		}
		return list;
	}

}
