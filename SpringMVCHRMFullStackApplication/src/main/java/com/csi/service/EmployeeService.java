package com.csi.service;

import java.util.List;

import com.csi.model.Employee;

public interface EmployeeService {
	public void save(Employee employee);

	public Employee findByEmpId(int empId);

	public List<Employee> findAll();

	public void deleteById(int empId);

	public void deleteAllData();

}
