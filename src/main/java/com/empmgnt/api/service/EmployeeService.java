package com.empmgnt.api.service;

import com.empmgnt.api.model.Employee;

public interface EmployeeService {

	Employee create(Employee employee);
	
	Employee selectById(Long id);
	
	Employee selectAll();
	
	Employee update(Long id, Employee employee);
	
	Employee delete(Long id);

}
