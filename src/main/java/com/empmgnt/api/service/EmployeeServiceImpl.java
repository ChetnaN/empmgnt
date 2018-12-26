package com.empmgnt.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmgnt.api.model.Employee;
import com.empmgnt.api.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee selectById(Long id) {
		Optional<Employee> optionalEntity =  employeeRepository.findById(id);
		return optionalEntity.get();

	}

	@Override
	public Employee selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee update(Long id, Employee employee) {
		
		if(id == employee.getId()) {
			return employeeRepository.save(employee);
		}
		return employeeRepository.save(employee);
		/*Employee employeeToUpdate = employeeRepository.findById(id).get();
		employeeToUpdate.setFirstname(employee.getFirstname());
		employeeToUpdate.setLastname(employee.getLastname());
		employeeToUpdate.setSalary(employee.getSalary());
		employeeToUpdate.setDesignation(employee.getDesignation());
		return employeeRepository.save(employeeToUpdate);*/
	}

	@Override
	public Employee delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
