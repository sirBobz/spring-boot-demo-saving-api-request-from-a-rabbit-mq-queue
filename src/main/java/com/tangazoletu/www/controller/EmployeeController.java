package com.tangazoletu.www.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tangazoletu.www.model.Employee;
import com.tangazoletu.www.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@Validated
public class EmployeeController {

	private static final Logger log = LogManager.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private com.tangazoletu.www.repository.EmployeeRepository EmployeeRepository;

	/**
	 * @param employeeService
	 */
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// Testing
	@GetMapping
	public ResponseEntity<List<Employee>> getAllTodos() {
		List<Employee> todos = EmployeeRepository.findAll();
		return new ResponseEntity<>(todos, HttpStatus.OK);
	}

	@PostMapping
	public String producer(@Valid @RequestBody Employee employee) {
		log.info("New API Request " + employee.toString());
		employeeService.send(employee);
		return "Operation Successfully";
	}
}
