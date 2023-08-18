package com.csi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeServiceImpl;

	@RequestMapping("/list")
	public String listEmployee(Model model) {

		model.addAttribute("empList", employeeServiceImpl.findAll());

		return "listEmployee";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		Employee employee = new Employee();

		model.addAttribute("employee", employee);

		return "addEmployee";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("empId") Integer empId, Model model) {

		Employee employee = employeeServiceImpl.findByEmpId(empId);

		model.addAttribute("employee", employee);

		return "addEmployee";
	}

	@PostMapping("/save")
	public String save(@RequestParam("empId") int empId, @RequestParam("empName") String empName,
			@RequestParam("empAddress") String empAddress, @RequestParam("empContactNumber") long empContactNumber,
			@RequestParam("empSalary") double empSalary) {

		Employee employee = null;

		if (empId != 0) {
			// update

			employee = employeeServiceImpl.findByEmpId(empId);
			employee.setEmpName(empName);
			employee.setEmpAddress(empAddress);
			employee.setEmpContactNumber(empContactNumber);
			employee.setEmpSalary(empSalary);

		} else {
			// save fresh data
			employee = new Employee(empName, empAddress, empContactNumber, empSalary);

		}

		employeeServiceImpl.save(employee);

		return "redirect:/employees/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("empId") int empId) {

		employeeServiceImpl.deleteById(empId);

		return "redirect:/employees/list";
	}

	@RequestMapping("/deletealldata")
	public String deleteAllData() {

		employeeServiceImpl.deleteAllData();

		return "redirect:/employees/list";
	}

}
