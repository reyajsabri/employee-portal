package com.employee.portal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.employee.portal.app.entity.Employee;

/**
 * @author reyaj.ahmed
 *
 */
@RepositoryRestResource
public interface EmployeeRepository  extends JpaRepository<Employee, String>{

}
