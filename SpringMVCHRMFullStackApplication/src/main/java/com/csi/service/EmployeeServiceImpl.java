package com.csi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDaoImpl;

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeDaoImpl.save(employee);
	}

	@Override
	public Employee findByEmpId(int empId) {
		// TODO Auto-generated method stub
		return employeeDaoImpl.findByEmpId(empId);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDaoImpl.findAll();
	}

	@Override
	public void deleteById(int empId) {
		// TODO Auto-generated method stub
		employeeDaoImpl.deleteById(empId);
	}

	@Override
	public void deleteAllData() {
		// TODO Auto-generated method stub
		employeeDaoImpl.deleteAllData();
	}

}
