package com.employee.portal.app.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.employee.portal.app.dto.EmployeeDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/Portal")
public class GatewayController {

	private final EmployeeClient employeeClient;

    public GatewayController(EmployeeClient employeeClient) {
        this.employeeClient = employeeClient;
    }

    private Collection<EmployeeDTO> fallback() {
        return new ArrayList<>();
    }
    
    @GetMapping(path = "/", produces = "text/html")
    public ModelAndView landingPage(Map<String, Object> model) {
        model.put("message", "Please Add Employee  !!");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addAllObjects(model).setViewName("Index");
        return modelAndView;
    }
    
    @GetMapping("/Employee")
    @CrossOrigin
    @HystrixCommand(fallbackMethod = "fallback")
    public Collection<EmployeeDTO> getAllEmployee() {
        return employeeClient.getAllEmployee()
                .getContent()
                .stream()
                .collect(Collectors.toList());
    }
}

@FeignClient("employee-service")
interface EmployeeClient {

    @GetMapping("/Employee/")
    @CrossOrigin
    Resources<EmployeeDTO> getAllEmployee();
}