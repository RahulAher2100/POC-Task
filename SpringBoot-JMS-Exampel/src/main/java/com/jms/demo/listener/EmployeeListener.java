package com.jms.demo.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.jms.demo.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmployeeListener {
	
	@JmsListener(destination = "${emp.jms.topic}", containerFactory = "empJmsContFactory")
    public void getEmployeeListener1(Employee emp) {
        log.info("Employee listener1: " + emp);
    }

    @JmsListener(destination = "${emp.jms.topic}", containerFactory = "empJmsContFactory")
    public void getEmployeeListener2(Employee emp) {
        log.info("Employee Listener2: " + emp);
    }
	
	

}
