package com.empmgnt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.empmgnt.api.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> { //,CrudRepository<Employee, Long> {

}
