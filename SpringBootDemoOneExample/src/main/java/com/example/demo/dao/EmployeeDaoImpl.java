package com.example.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	private SessionFactory sf; 

	@Override
	public void saveEmployeeData(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("Employe In Dao : " + employee);
		Session session = sf.openSession();
		session.save(employee);
		session.beginTransaction().commit();
	}

}
