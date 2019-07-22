package com.employee.portal.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.employee.portal.app.service.EmployeeService;
import com.employee.portal.app.util.TestDataUtill;

/**
 * @author reyaj.ahmed
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class EmployeeControllerTest {

	private MockMvc mockMvc;
	private TestDataUtill utill = new TestDataUtill();
	static {
		TestDataUtill.startHSQLDB();
	}
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	EmployeeService employeeService;
	
	@Before
	public void prepareMockMvc() {
		this.mockMvc = webAppContextSetup(this.webApplicationContext).build();
		
	}
	
	@Test
	public void addEmployee_Response_OK() throws Exception {
		this.mockMvc.perform(post("http://localhost:8090/employee-service/Employee/").contentType(MediaType.APPLICATION_JSON)
				  .content("{\"employeeId\":\"A\",\"name\":\"F\", \"salary\":\"120000\" ,\"active\":\"Y\"}")).andExpect(status().isOk());

	}
	
	@Test
	public void getAllEmployee_Response_OK() throws Exception {
		this.mockMvc.perform(get("http://localhost:8090/employee-service/Employee/")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}
	
	@AfterClass
	public static void tearDown() {
		TestDataUtill.stopHSQLDB();
	}
}
