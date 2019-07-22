package com.employee.portal.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.portal.app.entity.Employee;
import com.employee.portal.app.repository.EmployeeRepository;
import com.employee.portal.app.service.EmployeeService;

/**
 * @author reyaj.ahmed
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(String id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.saveAndFlush(employee);
	}

	@Override
	public List<Employee> saveAllEmployee(List<Employee> employees) {
		return employeeRepository.saveAll(employees);
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
		return true;
	}

	@Override
	public boolean deleteAllEmployee(List<Employee> employees) {
		employeeRepository.deleteAll(employees);
		return true;
	}

}
