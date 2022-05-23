package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class SpringbootBackendApplicationTests {
	@Autowired
	EmployeeRepository eRepo;

	//test case 1 to create a employee
	@Test
	@Order(1)
	public void testCreate() {
		Employee e = new Employee();
		
		
		e.setFirstName("arun");
		e.setLastName("Kumar");
		e.setEmailId("arun@gmail.com");
		e.setEmployeeId("10006");
		e.setPassword("12345");
		
		eRepo.save(e);
		assertNotNull(eRepo.findById(27L).get());
	}
	
	//test case 2 two get all employees
	@Test
	@Order(2)
	public void toGetEmployees() {
		List<Employee> list = eRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	//test case 3 to get employee details by id
	@Test
	@Order(3)
	public void toGetEmployeeById() {
		Employee employee = eRepo.findById(27L).get();
		assertEquals("Kumar",employee.getLastName());
		
	}
	
	//test case 4 to update
	@Test
	@Order(4)
	public void testUpdate() {
		Employee e = eRepo.findById(4L).get();
		e.setLastName("Reddy");
		eRepo.save(e);
		assertNotEquals("Kumar",eRepo.findById(4L).get().getLastName());
	}
	
	//test case 5 to delete 
	@Test
	@Order(5)
	public void testDelete() {
		eRepo.deleteById(39L);
		assertThat(eRepo.existsById(39L)).isFalse();
	}
}
