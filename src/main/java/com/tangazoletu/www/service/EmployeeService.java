package com.tangazoletu.www.service;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tangazoletu.www.model.Employee;

@Service
@Transactional
public class EmployeeService {

	private static final Logger log = LogManager.getLogger(EmployeeService.class);

	@Autowired
	private AmqpTemplate rabbitTemplate;

	/**
	 * @param rabbitTemplate
	 */
	public EmployeeService(AmqpTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@Value("${tangazoletu.rabbitmq.exchange}")
	private String exchange;

	@Value("${tangazoletu.rabbitmq.routingkey}")
	private String routingkey;

	public void send(Employee employee) {
		rabbitTemplate.convertAndSend(exchange, routingkey, employee);
		log.info("Send msg to queue= " + employee);

	}
}
