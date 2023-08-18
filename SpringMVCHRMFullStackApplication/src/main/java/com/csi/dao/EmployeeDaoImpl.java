package com.csi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.csi.model.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	SessionFactory factory;

	Session session;

	public EmployeeDaoImpl(SessionFactory factory) {
		// TODO Auto-generated constructor stub

		this.factory = factory;

		session = factory.openSession();
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub

		Transaction transaction = session.beginTransaction();

		session.saveOrUpdate(employee);

		transaction.commit();

	}

	@Override
	public Employee findByEmpId(int empId) {
		// TODO Auto-generated method stub
		return session.get(Employee.class, empId);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return session.createQuery("from Employee").list();
	}

	@Override
	public void deleteById(int empId) {
		// TODO Auto-generated method stub

		Transaction transaction = session.beginTransaction();

		session.delete(findByEmpId(empId));
		transaction.commit();
	}

	@Override
	public void deleteAllData() {
		// TODO Auto-generated method stub

		for (Employee employee : findAll()) {
			Transaction transaction = session.beginTransaction();

			session.delete(employee);

			transaction.commit();
		}
	}

}
