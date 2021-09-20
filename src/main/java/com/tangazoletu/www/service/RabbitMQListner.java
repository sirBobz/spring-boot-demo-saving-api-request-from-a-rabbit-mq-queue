package com.tangazoletu.www.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tangazoletu.www.model.Employee;
import com.tangazoletu.www.repository.EmployeeRepository;

@Component
public class RabbitMQListner {
	private static final Logger log = LogManager.getLogger(RabbitMQListner.class);

	@Autowired
	EmployeeRepository employeeRepository;

	/**
	 */
	public RabbitMQListner() {
		this.employeeRepository = employeeRepository;
	}

	@RabbitListener(queues = "${tangazoletu.rabbitmq.queue}")
	public void recievedMessage(Employee employee) {
		log.info("Consume API Request " + employee);
		employeeRepository.save(employee);
	}

}