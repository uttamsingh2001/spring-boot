package com.employeejpa.employeejpa;

import com.employeejpa.employeejpa.repository.EmployeeRepository;
import com.employeejpa.employeejpa.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
class EmployeejpaApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;


	public  void getAllEmployees()
	{
	}
}
