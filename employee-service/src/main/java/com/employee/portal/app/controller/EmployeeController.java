package com.employee.portal.app.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.portal.app.dto.EmployeeDTO;
import com.employee.portal.app.entity.Employee;
import com.employee.portal.app.service.EmployeeService;

/**
 * @author reyaj.ahmed
 *
 */
@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(value = "/", produces="application/json")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces="application/json")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") String id) {
		return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}
	
	@PostMapping(value = "/", produces="application/json")
	public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDTO employee){
		Employee emp = new Employee();
		emp.setName(employee.getName());
		emp.setEmployeeId(employee.getEmployeeId());
		emp.setActive(employee.getActive());
		emp.setCreatedBy(null);
		emp.setUpdatedBy(null);
		emp.setCreatedOn(LocalDateTime.now());
		emp.setUpdatedOn(LocalDateTime.now());
		emp.setSalary(employee.getSalary());
		emp.setVersion(1);
		return new ResponseEntity<>(employeeService.saveEmployee(emp), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces="application/json")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") String id){
		Employee emp = new Employee();
		emp.setEmployeeId(id);
		return new ResponseEntity<>(employeeService.deleteEmployee(emp), HttpStatus.OK);
	}

}
