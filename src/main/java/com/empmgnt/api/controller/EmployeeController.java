package com.empmgnt.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empmgnt.api.model.Employee;
import com.empmgnt.api.repository.EmployeeRepository;
import com.empmgnt.api.service.EmployeeService;


@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		employee = employeeService.create(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}
	
	@RequestMapping(value ="/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
		Employee employee = employeeService.selectById(id);
		if(employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@RequestMapping(value ="/{id}/update", method = RequestMethod.PUT)
	public void updateEmployee(@PathVariable(value = "id") int id, @RequestBody Employee employee) {
		System.out.println("Employee id : " + id);
		System.out.println("Employee Data : " + employee);
		/*System.out.println("Employee id : " + id);
		System.out.println("Employee Data : " + employee);
		employee = employeeService.update(id, employee);
		if(employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		*/
		
		
		/*Employee employee = EmployeeRepository.findById(id);
		        employee.setEmailId(employeeDetails.getEmailId());
		        employee.setLastName(employeeDetails.getLastName());
		        employee.setFirstName(employeeDetails.getFirstName());
		        final Employee updatedEmployee = EmployeeRepository.save(employee);
		        return ResponseEntity.ok(updatedEmployee);*/
	}
	
	/* @PutMapping("/employees/{id}")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
	         @Valid @RequestBody Employee employeeDetails) { // throws ResourceNotFoundException {
	        EmployeeRepository employeeRepository;
			Employee employee = employeeRepository.findById(employeeId);
	        //.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
	        employee.setFirstname(employeeDetails.getFirstname());
	        employee.setLastname(employeeDetails.getLastname());
	        employee.setSalary(employeeDetails.getSalary());
	        employee.setDesignation(employeeDetails.getDesignation());
	        final Employee updatedEmployee = employeeRepository.save(employee);
	        return ResponseEntity.ok(updatedEmployee);
	    }
	   /* @DeleteMapping("/employees/{id}")
	    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
	         throws ResourceNotFoundException {
	        Employee employee = employeeRepository.findById(employeeId)
	       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
	        employeeRepository.delete(employee);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }*/
}
