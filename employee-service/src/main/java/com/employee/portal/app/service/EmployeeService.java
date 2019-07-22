package com.employee.portal.app.service;

import java.util.List;

import com.employee.portal.app.entity.Employee;

/**
 * @author reyaj.ahmed
 *
 */
public interface EmployeeService {

	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(String id);
	public Employee saveEmployee(Employee employee);
	public List<Employee> saveAllEmployee(List<Employee> employees);
	public boolean deleteEmployee(Employee employee);
	public boolean deleteAllEmployee(List<Employee> employees);
}
